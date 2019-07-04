package com.spring.annotation;

import com.spring.annotation.bean.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.annotation.bean.Color;
import com.spring.annotation.config.MainConfig;
import com.spring.annotation.config.PropertiesConfig;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testBean(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("容器创建完成！");
        Color bean = applicationContext.getBean(Color.class);
        //System.out.println(bean);
        applicationContext.close();
    }

    @Test
    public void testProperties(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PropertiesConfig.class);
        System.out.println("容器创建完成！");
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean.getName());
        System.out.println(bean.getSex());
        applicationContext.close();
    }
}
