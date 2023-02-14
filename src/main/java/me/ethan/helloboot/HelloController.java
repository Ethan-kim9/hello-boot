package me.ethan.helloboot;


import java.util.Objects;

public class HelloController {
    private final HelloService helloService;// 초기화 진행

    // 생성자 주입을 통한 DI
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name){
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
