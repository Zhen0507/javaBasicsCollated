package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 */
@Aspect
@Component
public class LoggingAspect {
    
    // 定义切点
    @Pointcut("execution(* com.example.service.Calculator.*(..))")
    public void calculatorOperation() {}
    
    // 前置通知
    @Before("calculatorOperation()")
    public void beforeAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("【前置通知】执行方法: " + methodName + ", 参数: " + 
                          args[0] + ", " + args[1]);
    }
    
    // 后置通知
    @After("calculatorOperation()")
    public void afterAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("【后置通知】方法执行完成: " + methodName);
    }
    
    // 返回通知
    @AfterReturning(pointcut = "calculatorOperation()", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("【返回通知】方法: " + methodName + ", 返回值: " + result);
    }
    
    // 异常通知
    @AfterThrowing(pointcut = "calculatorOperation()", throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("【异常通知】方法: " + methodName + ", 异常: " + ex.getMessage());
    }
    
    // 环绕通知
    @Around("calculatorOperation()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("【环绕通知】方法执行前: " + methodName);
        
        try {
            // 执行目标方法
            Object result = joinPoint.proceed();
            System.out.println("【环绕通知】方法执行后: " + methodName);
            return result;
        } catch (Exception e) {
            System.out.println("【环绕通知】方法异常: " + e.getMessage());
            throw e;
        }
    }
} 