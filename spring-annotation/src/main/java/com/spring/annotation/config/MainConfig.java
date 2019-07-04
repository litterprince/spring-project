package com.spring.annotation.config;

import com.spring.annotation.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"spring.project.bean"})
public class MainConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Color color(){
        System.out.println("create color ...");
        return new Color();
    }
}
