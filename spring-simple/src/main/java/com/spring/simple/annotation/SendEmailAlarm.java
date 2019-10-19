package com.spring.simple.annotation;

import java.lang.annotation.*;

/**
 * <p>Title: SendEmailAlarm. </p>
 * <p>Description 发送报警邮件注解 </p>
 * <p>Company: http://www.koolearn.com </p>
 * @author wangzhe01@koolearn-inc.com
 * @date 2019-10-18 17:50
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SendEmailAlarm {
    /**
     * 邮件标题
     * @return title
     */
    String title();

    /**
     * 系统类型
     * @return systemType
     */
    String systemType();

    /**
     * 系统名称
     * @return systemName
     */
    String systemName();
}
