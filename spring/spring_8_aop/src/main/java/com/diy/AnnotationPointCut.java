package com.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//方式三
//标志这个类是一个切面
@Aspect
public class AnnotationPointCut {
    @Before("execution(* com.wsl.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("====方法执行前====");
    }
  @After("execution(* com.wsl.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("====方法执行后====");
    }
    //在环绕增强中，我们可以给到一个参数，代表我们要获取处理切入点
    @Around("execution(* com.wsl.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        //获得签名
        Signature signature = jp.getSignature();
        System.out.println(signature);
        //执行方法
        Object proceed = jp.proceed();
        System.out.println("环绕后");
    }
}
