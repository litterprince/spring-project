package com.spring.simple.annotation;

import java.lang.annotation.*;

/**
 * <p>Title: AbstractSendEmailAlarm. </p>
 * <p>Description 抽象类专用发送报警邮件注解 </p>
 * <p>Company: http://www.koolearn.com </p>
 * @author wangzhe01@koolearn-inc.com
 * @date 2019-10-18 17:50
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AbstractSendEmailAlarm {
    /**
     * 邮件标题方法名（反射调用）
     * @return title
     */
    String titleMethodName();

    /**
     * 系统类型
     * @return systemType
     */
    String systemType() default "";

    /**
     * 系统名称
     * @return systemName
     */
    String systemName() default "";
}
