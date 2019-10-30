package com.spring.simple.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.spring.simple.annotation.OfflineMethod;

/**
 * 接口下线功能切面
 * @author wangzhe01@Koolearn-inc.com
 */
@Aspect
@Component
public class OfflineAspect {

    private static final Logger logger = LoggerFactory.getLogger(OfflineAspect.class);

    @Pointcut("@annotation(com.spring.simple.annotation.OfflineMethod)")
    public void offlinePointCut() {
    }

    @Before("offlinePointCut()")
    public void  around(JoinPoint point) throws Exception {
        // 注解信息
        MethodSignature signature = (MethodSignature) point.getSignature();
        OfflineMethod annotation = signature.getMethod().getAnnotation(OfflineMethod.class);

        // 类信息
        String className = point.getTarget().getClass().getSimpleName();
        String methodName = point.getSignature().getName();

        logger.debug("### offlinePointCut className:{}, methodName:{}", className, methodName);
        throw new Exception(annotation.value());
        
    }

}
