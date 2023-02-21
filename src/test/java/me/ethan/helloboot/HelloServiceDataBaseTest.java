package me.ethan.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@HellobootDatabaseTest
@Transactional
public class HelloServiceDataBaseTest {
    @Autowired HelloService helloService;
    @Autowired HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount(){
        IntStream.rangeClosed(1, 10).forEach( count ->{
            helloService.sayHello("Ethan");
            Assertions.assertThat(helloRepository.countOf("Ethan")).isEqualTo(count);
        });
    }
}
