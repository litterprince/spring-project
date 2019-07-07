package com.spring.annotation;

import com.spring.annotation.bean.Dog;
import com.spring.annotation.config.PropertiesConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PropertiesConfig.class);
        Dog bean = context.getBean(Dog.class);
        System.out.println(bean);
    }

}
