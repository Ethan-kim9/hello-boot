package me.ethan.helloboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HelloControllerTest {

    /**
     * UnitTest, 단위 테스트
     */


    @Test
    void helloController(){

        HelloController helloController = new HelloController(name -> name);

        String ret = helloController.hello("Test");

        assertThat(ret).isEqualTo("Test");
    }

    @Test
    void failsHelloController(){
        HelloController helloController = new HelloController(name -> name);

        assertThatThrownBy(()-> helloController.hello(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> helloController.hello(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}