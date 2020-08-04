package cn.it.config;

import cn.it.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * author: mxg
 */
@Configuration
//@ComponentScan("cn.it")
public class Appconfig {

    @Bean
    public Person person() {
        return new Person("使用bean注解");
    }
}
