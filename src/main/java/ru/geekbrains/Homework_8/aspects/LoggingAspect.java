package ru.geekbrains.Homework_8.aspects;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import ru.geekbrains.Homework_8.service.AutoService;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(AutoService.class.getName());

    @Around(value = "@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        System.out.println("Метод " + methodName + " с параметрами " + Arrays.asList(arguments) + " был выполнен!!!");

        // System.out.println("выполняется команда!");
        // logger.info("выполняется команда команда!");
        Object returnByMethod = joinPoint.proceed();
        System.out.println("команда выполнена!");
        // logger.info("команда выполнена!");
        return returnByMethod;
    }

    @Around(value = "@annotation(ToLog)")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Метод " + joinPoint.getSignature().getName() + " выполнен за - " + elapsedTime + " милесекунд");
        return result;
    }
}
