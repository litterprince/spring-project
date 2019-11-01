package com.spring.simple.aspect;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.spring.simple.annotation.OfflineMethod;

/**
 * 接口下线功能切面
 * @author wangzhe01@Koolearn-inc.com
 */
@Aspect
@Component
@Slf4j
public class OfflineAspect {

    @Pointcut("@annotation(com.spring.simple.annotation.OfflineMethod)")
    public void offlinePointCut() {
    }

    @Before("offlinePointCut()")
    public void around(JoinPoint point) {
        // 注解信息
        MethodSignature signature = (MethodSignature) point.getSignature();
        OfflineMethod annotation = signature.getMethod().getAnnotation(OfflineMethod.class);

        // 类信息
        String className = point.getTarget().getClass().getSimpleName();
        String methodName = point.getSignature().getName();

        log.info("### offlinePointCut className:{}, methodName:{}", className, methodName);
        throw new RuntimeException(annotation.value());

    }

    /*@Around("offlinePointCut()")
    public Object deleteCache(ProceedingJoinPoint point) throws Throwable {
        // 执行目标方法
        Object result = point.proceed();

        // 获取目标方法信息
        MethodSignature signature = (MethodSignature) point.getSignature();
        OfflineMethod annotation = signature.getMethod().getAnnotation(OfflineMethod.class);
        Object[] args = point.getArgs();
        String value = annotation.value();
        log.info("### annotation value:{}", value);

        // 获取缓存前缀
        assert args != null;
        log.info("### offlinePointCut args: {}", args);

        return result;
    }*/

}
