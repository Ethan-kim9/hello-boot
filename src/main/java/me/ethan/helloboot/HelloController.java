package me.ethan.helloboot;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final HelloService helloService;// 초기화 진행

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name){
        if(name==null || name.trim().length() == 0) throw  new IllegalArgumentException();
        return helloService.sayHello(name);
    }
}
