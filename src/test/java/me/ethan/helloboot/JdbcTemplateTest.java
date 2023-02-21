package me.ethan.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@HellobootDatabaseTest
public class JdbcTemplateTest {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Test
    void insertAndQuery(){
        jdbcTemplate.update("insert into hello values(?,?)", "Ethan",2);
        jdbcTemplate.update("insert into hello values(?,?)", "Spring",1);

        Long count = jdbcTemplate.queryForObject("select count (*) from hello", Long.class);
        assertThat(count).isEqualTo(2);
    }
    @Test
    void transactionTest(){
        jdbcTemplate.update("insert into hello values(?,?)", "Ethan",2);
        jdbcTemplate.update("insert into hello values(?,?)", "Spring",1);

        Long count = jdbcTemplate.queryForObject("select count (*) from hello", Long.class);
        assertThat(count).isEqualTo(2);
    }


}
