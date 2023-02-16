package me.ethan.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloServiceTest {

    @Test
    void simpleHelloService(){
        SimpleHelloService helloService =new SimpleHelloService();

        String test = helloService.sayHello("test");

        assertThat(test).isEqualTo("Hello test");
        // 고립된 테스트가 가능하다.
    }


    @Test
    void helloDecorator(){
        HelloDecorator decorator = new HelloDecorator(name -> name);
        String ret = decorator.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("*Test*");
    }
}