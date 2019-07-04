package com.spring.annotation.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 生命周期:
 * 1、@Bean指定initMethod,destroyMethod
 * 2、对象继承InitializingBean和DisposableBean
 * 3、注册BeanPostProcessor后置处理器
 * 4、@PostConstruct,@PreDestroy注解
 *
 * 初始化时：构造器Construct  ->  属性注入  ->  @PostConstruct  ->  InitializingBean接口afterPropertiesSet  ->  bean定义的initMethod
 * 销毁时：@PreDestroy  ->  DisposableBean接口destroy ->  bean定义的destroyMethod
 */
public class Color implements InitializingBean, DisposableBean {
    public Color() {
        System.out.println("color constructor ...");
    }

    // 构造方法之后调用
    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct ...");
    }

    // properties设置完之后调用
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet ...");
    }

    // 初始化方法
    public void initMethod(){
        System.out.println("color init method ...");
    }

    // 容器移除对象之前调用
    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy ...");
    }

    // 容器移除对象之前调用
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy ...");
    }

    // 销毁后方法
    public void destroyMethod(){
        System.out.println("color destroy method ...");
    }

}
