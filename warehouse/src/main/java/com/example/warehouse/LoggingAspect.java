package com.example.warehouse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        String logMessage = String.format("[%s] Method %s executed in %d ms\n",
                LocalDateTime.now(), joinPoint.getSignature(), duration);

        try (FileWriter writer = new FileWriter("/logs/app.log", true)) {
            writer.write(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}