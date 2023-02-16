package me.ethan.helloboot;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // ResponseBody 가 적혀있음 , @RequestMapping 이 있을것이라고 DispatcherServlet 이 판단함
public class HelloController {
    private final HelloService helloService;// 초기화 진행

    // 생성자 주입을 통한 DI
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello") //dispatcher Servlet 에서, applicationContext(servlet) 를 파라미터로 생성될 때, 모든 bean 을 순회하며 mapping 정보를 색인
    public String hello(String name){
        if(name==null || name.trim().length() == 0) throw  new IllegalArgumentException();
        return helloService.sayHello(name);
    }

    // String 으로 Return 할 경우, view 를 찾음
}
