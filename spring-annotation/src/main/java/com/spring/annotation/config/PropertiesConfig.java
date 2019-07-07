package com.spring.annotation.config;

import com.spring.annotation.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:config.properties")
public class PropertiesConfig {

    @Bean
    public Dog dog() {
        return new Dog();
    }
}
