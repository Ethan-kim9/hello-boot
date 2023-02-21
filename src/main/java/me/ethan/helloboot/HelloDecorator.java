package me.ethan.helloboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // HelloService 를 구현한 빈 중에 우선순위를 가지게 됨
public class HelloDecorator implements HelloService{

    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService; // 이경우 후순위인 simpleHelloService 를 주입받게됨
    }

    @Override
    public String sayHello(String name) {
        return helloService.sayHello(name);
    }

    @Override
    public int countOf(String name) {
        return helloService.countOf(name);
    }

}
