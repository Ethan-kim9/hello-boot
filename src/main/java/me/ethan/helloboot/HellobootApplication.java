package me.ethan.helloboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

public class HellobootApplication {

    public static void main(String[] args) {
        System.out.println("Hello Containerless standalone Application");

        // 스프링 컨테이너 (ApplicationContext 생성)
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        applicationContext.registerBean(HelloController.class);
        applicationContext.refresh();


        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        WebServer webServer = tomcatServletWebServerFactory.getWebServer(servletContext -> {
            servletContext.addServlet("hello", new HttpServlet() {
                        @Override
                        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                            // 인증, 보안 , 다국어 처리 , 공통 기능
                            if(req.getRequestURI().equals("/hello")
                                    && req.getMethod().equals(HttpMethod.GET.name())
                            ){
                                String name = req.getParameter("name");

                                // Bean 을 ApplicationContext 로 가져오는 것
                                HelloController helloController = applicationContext.getBean(HelloController.class);
                                String hello = helloController.hello(name);

                                resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
                                resp.getWriter().println(hello);
                            }
                            else{
                                resp.setStatus(HttpStatus.NOT_FOUND.value());
                            }
                        }
                    }).addMapping("/*");

        });
        webServer.start();
    }
}
