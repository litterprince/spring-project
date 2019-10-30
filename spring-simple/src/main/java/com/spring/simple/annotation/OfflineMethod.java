package com.spring.simple.annotation;

import java.lang.annotation.*;

/**
 * 接口下线注解
 * @author wangzhe01@Koolearn-inc.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OfflineMethod {
    /**
     * 返回错误信息内容
     */
    String value() default "该接口已经下线！";
}
