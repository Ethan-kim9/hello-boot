package me.ethan.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {


    /**
     * Bean 1 <-- common
     * Bean 2 <-- common
     * Bean1 과 Bean2 는 같다.
     */

    @Test
    void configuration(){

        Assertions.assertThat(new Common()).isNotEqualTo(new Common());

        MyConfig myConfig = new MyConfig();
        Bean1 bean1 = myConfig.bean1();
        Bean2 bean2 = myConfig.bean2();

        Assertions.assertThat(bean1.common).isNotEqualTo(bean2.common);
    }

    @Test
    void springConfiguration(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // Spring 을 이용한 주입의 경우, 두가지 오브젝트가 동일하다.

        applicationContext.register(MyConfig.class);
        applicationContext.refresh();
        Bean1 bean1 = applicationContext.getBean(Bean1.class);
        Bean2 bean2 = applicationContext.getBean(Bean2.class);

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    @Test
    void proxyCommonMethod(){
        // 스프링 컨테이너에 도움을 받진 않았지만, 캐싱을 통해서 스프링 컨테이너를 흉내낸 경우

        MyConfigProxy myConfigProxy = new MyConfigProxy();

        Bean1 bean1 = myConfigProxy.bean1();
        Bean2 bean2 = myConfigProxy.bean2();

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    static class MyConfigProxy extends MyConfig {
        private Common common;

        @Override
        Common common() {
            if(this.common==null) this.common = super.common();
            return this.common;
         }
    }


    @Configuration
    static class MyConfig{
        @Bean
        Common common(){
            return new Common();
        }

        @Bean
        Bean1 bean1(){
            return new Bean1(common());
        }
        @Bean
        Bean2 bean2(){
            return new Bean2(common());
        }
    }

    static class Bean1{
        private final Common common;

        public Bean1(Common common) {
            this.common = common;
        }
    }

    static class Bean2{
        private final Common common;

        public Bean2(Common common) {
            this.common = common;
        }
    }
    static class Common{

    }
}


