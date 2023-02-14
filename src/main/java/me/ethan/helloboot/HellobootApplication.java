package me.ethan.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HellobootApplication {

    public static void main(String[] args) {
        System.out.println("Hello Containerless standalone Application");

        // 스프링 컨테이너 (ApplicationContext 생성)
        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
        applicationContext.registerBean(HelloController.class);
        /**
         * HelloController 를 생성하는 과정에서, 주입하는 Service 등의 빈을 확인하고 그 과정에서 구현체의 Bean 도 스프링 컨테이너에서 관리하게 됨
         * - 흐름상, SimpleHelloService 가 먼저 Bean 등록이 되어야할 것 같지만, 등록되는 순서는 상관없음 -> 스프링에서 알아서 관리
         */
        applicationContext.registerBean(SimpleHelloService.class);// 구현체를 Bean 으로 등록함

        applicationContext.refresh();


        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();

        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("dispatcherServlet",
                    new DispatcherServlet(applicationContext)
                    ).addMapping("/*");
        });
        /**
         * 기존 Servlet 을 하나하나 등록하던 것을 DispatcherServlet 으로 변경해줌
         * Servlet에 url 하나하나 연동해주던 것을 Controller 에서 받게끔 변경해줌
         * */


        webServer.start();
    }
}
