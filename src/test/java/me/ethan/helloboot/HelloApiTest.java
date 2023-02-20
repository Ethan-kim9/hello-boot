package me.ethan.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloApiTest {
    @Test
    void helloApi(){
        // http:localhost:8080/hello?name=Spring


        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> response =
                rest.getForEntity("http://localhost:9090/app/hello?name={name}", String.class, "Spring");


        //status code 200
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        //header (Content-Type) text/plain
        assertThat(response.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body Hello Spring
        assertThat(response.getBody()).isEqualTo("Hello Spring");
    }

    @Test
    void failsHelloApi(){
        // http:localhost:8080/hello?name=Spring


        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> response =
                rest.getForEntity("http://localhost:9090/app/hello?name=", String.class);


        //status code 200
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
