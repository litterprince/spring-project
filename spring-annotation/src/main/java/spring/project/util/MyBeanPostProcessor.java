package spring.project.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置处理器类
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    // 构造方法之后，PostConstruct之前调用
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " postProcessBeforeInitialization ...");
        return bean;
    }

    // initMethod初始化方法调用之后
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " postProcessAfterInitialization ...");
        return bean;
    }
}
