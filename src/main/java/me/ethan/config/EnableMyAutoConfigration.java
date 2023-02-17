package me.ethan.config;

import me.ethan.config.autoconfig.DispatcherServletConfig;
import me.ethan.config.autoconfig.TomcatWebServerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({DispatcherServletConfig.class, TomcatWebServerConfig.class}) // 다른패키지의 빈을 import 해줌, componentScan 을 한 것이 아님을 기억
public @interface EnableMyAutoConfigration {
}
