package me.ethan.helloboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HellobootApplication.class)
@PropertySource("classpath:/application.properties")
public class DataSourceTest {

    @Autowired DataSource dataSource;

    @Test
    void connect()throws SQLException{
        Connection connection = dataSource.getConnection();
        connection.close();
    }

}
