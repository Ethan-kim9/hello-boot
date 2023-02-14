package me.ethan.helloboot;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

//@Controller
@RequestMapping // Dispatcher Servlet 에서 메서드레벨의 매핑값을 찾을 수 있게, 클래스레벨에서 찾게해줌
//
public class HelloController {
    private final HelloService helloService;// 초기화 진행

    // 생성자 주입을 통한 DI
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello") //dispatcher Servlet 에서, applicationContext(servlet) 를 파라미터로 생성될 때, 모든 bean 을 순회하며 mapping 정보를 색인
    @ResponseBody
    public String hello(String name){
        return helloService.sayHello(Objects.requireNonNull(name));
    }

    // String 으로 Return 할 경우, view 를 찾음
}
