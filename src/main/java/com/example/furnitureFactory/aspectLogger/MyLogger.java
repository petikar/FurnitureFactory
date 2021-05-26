package com.example.furnitureFactory.aspectLogger;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@Aspect
public class MyLogger {

    @Pointcut("execution(* com.example.furnitureFactory.*.*.*.*(..))")
    public void callLogger() {
    }

    @Pointcut("execution(void com.example.furnitureFactory.*.*.*.*(..))")
    public void callVoidLogger() {
 }


    @Around("callVoidLogger()")
    public void logVoidCall(ProceedingJoinPoint proceedingJoinPoint) {
        Signature methodName = proceedingJoinPoint.getSignature();
        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println("Method " + methodName + " was called with args: " + Arrays.toString(args));
            try {
                proceedingJoinPoint.proceed();
                System.out.println("Method " + methodName + " returns void");
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
    }

    @Around("callLogger()&&!callVoidLogger()")
    public Object logCall(ProceedingJoinPoint proceedingJoinPoint) {
        Signature methodName = proceedingJoinPoint.getSignature();
        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println("Method " + methodName + " was called with args: " + Arrays.toString(args));
        try {
            Object result = proceedingJoinPoint.proceed();
            System.out.println("Method " + methodName + " returns " + result);
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
