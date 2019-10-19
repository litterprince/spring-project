package com.spring.simple.aspect;

import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.spring.simple.annotation.AbstractSendEmailAlarm;
import com.spring.simple.annotation.SendEmailAlarm;

/**
 * @author wangzhe01
 */
@Aspect
@Component
@Slf4j
public class EmailAspect {

    /**
     * <p>Title: pointcut</p>
     * <p>定义切面表达式</p>
     *
     * @author wangzhe01@Koolearn-inc.com
     * @date 2019/10/18 16:16
     */
    @Pointcut("@annotation(com.spring.simple.annotation.SendEmailAlarm)")
    public void pointcut() {
    }

    /**
     * 时序关系
     * @param point 切点
     * @return 结果
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        log.debug("### EmailAspect enter!");

        Object result;
        SendEmailAlarm annotation = null;
        StringBuilder sb = new StringBuilder();
        try {
            MethodSignature signature = (MethodSignature) point.getSignature();
            annotation = signature.getMethod().getAnnotation(SendEmailAlarm.class);
            if (annotation != null) {
                log.info("### EmailAspect send email alarm open!");

                // 获取类信息
                String classType = point.getTarget().getClass().getName();
                Class<?> clazz = Class.forName(classType);
                String clazzName = clazz.getName();
                String methodName = point.getSignature().getName();
                String params = JSONObject.toJSONString(point.getArgs());

                sb.append("clazzName: ").append(clazzName).append("<br/>");
                sb.append("methodName: ").append(methodName).append("<br/>");
                sb.append("params: ").append(params).append("<br/>");

                if (log.isDebugEnabled()) {
                    log.debug("### EmailAspect param, sb: {}", sb.toString());
                }
            }

            result = point.proceed();
        }
        catch (Throwable e) {
            if (annotation != null) {
                log.info("### EmailAspect catch exception! send email alarm start!");
            }
            throw e;
        }

        return result;
    }

    /**
     * <p>Title: abstractPointcut</p>
     * <p>定义抽象类的切面表达式</p>
     *
     * @author wangzhe01@Koolearn-inc.com
     * @date 2019/10/18 16:16
     */
    @Pointcut("@annotation(com.spring.simple.annotation.AbstractSendEmailAlarm)")
    public void abstractPointcut() {
    }

    /**
     *
     * @param point 切点
     * @return 结果
     */
    @Around("abstractPointcut()")
    public Object abstractAround(ProceedingJoinPoint point) throws Throwable {
        log.debug("### EmailAspect abstract enter!");

        Object result;
        AbstractSendEmailAlarm annotation = null;
        StringBuilder sb = new StringBuilder();
        String emailTitle = "";
        try {
            MethodSignature signature = (MethodSignature) point.getSignature();
            annotation = signature.getMethod().getAnnotation(AbstractSendEmailAlarm.class);
            if (annotation != null) {
                log.info("### EmailAspect abstract send email alarm open!");

                // 获取类信息
                String classType = point.getTarget().getClass().getName();
                Class<?> clazz = Class.forName(classType);
                String clazzName = clazz.getName();
                String methodName = point.getSignature().getName();
                String params = JSONObject.toJSONString(point.getArgs());

                // 反射执行获取邮件标题方法
                Method titleMethod = clazz.getDeclaredMethod(annotation.titleMethodName());
                if (null != titleMethod) {
                    titleMethod.setAccessible(true);
                    emailTitle = (String) titleMethod.invoke(point.getTarget());
                    log.info("### EmailAspect abstract, have this method! emailTitle: {}", emailTitle);
                }

                sb.append("clazzName: ").append(clazzName).append("<br/>");
                sb.append("methodName: ").append(methodName).append("<br/>");
                sb.append("params: ").append(params).append("<br/>");

                if (log.isDebugEnabled()) {
                    log.debug("### EmailAspect abstract param, sb: {}, title: {}, ", sb.toString(), emailTitle);
                }
            }

            result = point.proceed();
        }
        catch (Throwable e) {
            if (annotation != null && !"".equals(emailTitle)) {
                log.info("### EmailAspect abstract catch exception! send email alarm start!");

            }
            throw e;
        }

        return result;
    }

}
