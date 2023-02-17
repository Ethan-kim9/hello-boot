package me.ethan.config;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration(proxyBeanMethods = false)// 해당 어노테이션이 붙어있는 경우엔, proxyBeanMethod 를 false 로 바꾸고 적용한다.
public @interface MyAutoConfiguration {
}
