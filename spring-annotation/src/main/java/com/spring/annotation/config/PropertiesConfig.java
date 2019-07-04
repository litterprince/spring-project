package com.spring.annotation.config;

import com.spring.annotation.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/person.properties")
public class PropertiesConfig {

    @Bean
    public Person person(){
        return new Person();
    }
}
