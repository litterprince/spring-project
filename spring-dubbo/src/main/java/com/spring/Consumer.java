package com.spring;

import com.spring.service.LicenseTransformService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});
        context.start();

        LicenseTransformService service = (LicenseTransformService) context.getBean("licenseTransform");
        service.startTransform();
    }
}
