package me.ethan.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class HelloRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired HelloRepository helloRepository;

    @Test
    void findHelloFailed(){
        Assertions.assertThat(helloRepository.findHello("Ethan")).isNull();
    }

    @Test
    void increaseCount(){
        Assertions.assertThat(helloRepository.countOf("Ethan")).isEqualTo(0);
        helloRepository.increaseCount("Ethan");
        Assertions.assertThat(helloRepository.countOf("Ethan")).isEqualTo(1);
        helloRepository.increaseCount("Ethan");
        Assertions.assertThat(helloRepository.countOf("Ethan")).isEqualTo(2);
    }
}