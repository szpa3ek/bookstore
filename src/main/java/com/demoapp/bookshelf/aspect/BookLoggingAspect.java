package com.demoapp.bookshelf.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static java.lang.System.currentTimeMillis;

@Aspect
@Component
public class BookLoggingAspect {

    @Around("execution(* *(..)) && (execution(* com.demoapp.bookshelf.service.BookService.*(..)))")
    public Object measureExecutionTime(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        long startTime = currentTimeMillis();
        System.out.println(":: aspect beginning ::");
        Object result = thisJoinPoint.proceed();
        System.out.println(":: aspect end ::");
        System.out.println(thisJoinPoint + " -> " + (currentTimeMillis() - startTime) + " ms");
        return result;
    }
}
