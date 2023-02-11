package me.ethan.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // HTML 을 통채로 리턴하는 것이 아닌, HTTP 요청에 대한 응답을 특정 타입으로 리턴하는 컨트롤러
public class HelloController {

    @GetMapping("/hello")
    public String hello(String name){
        return "hello " + name;
    }

}
