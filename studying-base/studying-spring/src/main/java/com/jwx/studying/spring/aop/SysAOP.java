package com.jwx.studying.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * PackageName:com.jwx.studying.spring.aop
 * FileName: SysAOP.java
 * Description: TODO
 * Copyright: Copyright (c)2018
 * Company: songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/10
 */
@Aspect
@Component
public class SysAOP {

    /**
     * 切入点
     *  <p>@Pointcut("@annotation(FuncAnnotation)")
     */
    @Pointcut(value = "execution(* com.jwx.studying.spring.aop.*(..))")
    public void pointcut() {}


    /**
     * 前置通知，在连接点前面执行
     */
    @Before(value = "pointcut()")
    public  void before(JoinPoint joinPoint){

    }

    /**
     *  环绕通知, 围绕着连接点执行
     */
    @Around(value = "pointcut()")
    public void around(ProceedingJoinPoint joinPoint) {
        Object o=null;
        try {
            System.out.println("======执行环绕通知开始=========");
            // 调用方法的参数
            Object[] args = joinPoint.getArgs();
            // 调用的方法
            /* String method = joinPoint.getSignature().getName();*/
            Object obj = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) obj;
            Method method = methodSignature.getMethod();
            // 获取方法所属类目标对象
            Object target = joinPoint.getTarget();
            System.out.println("======执行环绕通知结束=========");
        } catch (Throwable t) {
            System.out.println(String.format("error{}", t.getMessage()));
        }
    }

    /**
     * 后置通知，在连接点后执行
     */
    @After(value = "pointcut()")
    public  void after(JoinPoint joinPoint){

    }

    /**
     * 返回通知，在目标连接点处成功执行之后执行
     */
    @AfterReturning(value = "pointcut()")
    public  void afterReturn(JoinPoint joinPoint){

    }

    /**
     * 异常通知，在目标连接点处抛出异常后执行
     */
    @AfterThrowing(value = "pointcut()")
    public  void afterThrow(JoinPoint joinPoint){

    }

}
