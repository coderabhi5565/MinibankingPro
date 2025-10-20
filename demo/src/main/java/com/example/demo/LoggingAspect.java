package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.example.demo.CustomerService.deposit(..))")
    public Object logDepositMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("---- Deposit method started ----");

        Object result = joinPoint.proceed();

        System.out.println("---- Deposit method ended ----");
        return result;
    }

    @Around("execution(* com.example.demo.CustomerService.withdraw(..))")
    public Object logwithdrawmethod(ProceedingJoinPoint join) throws Throwable{
        System.out.println("Withdraw Method Started..");
        Object result = join.proceed();
        System.out.println("Withdraw method ended");
        return result;
    }
}
