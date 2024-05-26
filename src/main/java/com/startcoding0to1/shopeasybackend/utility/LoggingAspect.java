package com.startcoding0to1.shopeasybackend.utility;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);
    private static final Gson gson=new Gson();

    @Pointcut("execution(* com.startcoding0to1.shopeasybackend.*impl.*Impl.*(..))")
    public void implMethods(){}


    @Pointcut("execution(* com.startcoding0to1.shopeasybackend.controller.*Controller.*(..))")
    public void controllerMethods(){}

    @Before("implMethods()")
    public void logBeforeAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getMethod().getName();
        Object[] args = joinPoint.getArgs();
        String[] parameterNames = methodSignature.getParameterNames();

        StringBuilder message = new StringBuilder();
        message.append("Method ").append(methodName);
        message.append("() called");

        // Append parameters if there are any
        if (args.length > 0) {
            message.append(" with parameters: ");
            for (int i = 0; i < args.length; i++) {
                message.append(parameterNames[i] + ": ").append(gson.toJson(args[i])).append(", ");//parameter: value
            }

            // Remove the trailing comma and space
            message.setLength(message.length() - 2);// or we can use message.delete(message.length() - 2, message.length());
            message.append(".");
        }
        LOGGER.info(message.toString());
    }

    @AfterReturning(pointcut = "implMethods()", returning = "result")
    public void logAfterReturningAdvice(JoinPoint joinPoint, Object result) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();
        Type returnType = methodSignature.getMethod().getGenericReturnType();
        String formattedReturnType = formatReturnType(returnType);
        LOGGER.info("Method {} returned with type {}: {}.", methodName, formattedReturnType, gson.toJson(result));
    }

    private String formatReturnType(Type returnType) {
        if (returnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) returnType;
            StringBuilder typeString = new StringBuilder(getSimpleName(parameterizedType.getRawType().getTypeName()));
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            if (typeArguments.length > 0) {
                typeString.append("<");
                for (Type typeArgument : typeArguments) {
                    typeString.append(getSimpleName(typeArgument.getTypeName())).append(", ");
                }
                typeString.setLength(typeString.length() - 2); // Remove the trailing comma and space
                typeString.append(">");
            }
            return typeString.toString();
        } else {
            return getSimpleName(returnType.getTypeName());
        }
    }

    private String getSimpleName(String fullTypeName) {
        int lastDotIndex = fullTypeName.lastIndexOf('.');
        return (lastDotIndex != -1) ? fullTypeName.substring(lastDotIndex + 1) : fullTypeName;
    }

    @AfterThrowing(pointcut = "implMethods()",throwing = "exception")
    public void logAfterThrowingAdvice(JoinPoint joinPoint, Exception exception){
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        String methodName=methodSignature.getMethod().getName();
        LOGGER.error("Method {} thrown an exception {}.",methodName,exception);
    }

    @After("implMethods()")
    public void logAfterAdvice(JoinPoint joinPoint){
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        String methodName=methodSignature.getMethod().getName();
        LOGGER.info("Method {} execution completed.",methodName);
    }


//    For debugging
    @Around("implMethods() || controllerMethods()")
    public Object logAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String methodName=proceedingJoinPoint.getSignature().getName();
        String className=proceedingJoinPoint.getTarget().getClass().getSimpleName();
        String message=String.format("Entring into the method %s.%s().",className,methodName);
        LOGGER.debug(message);
        Object result=proceedingJoinPoint.proceed();
        LOGGER.debug("Exit from the method {}.{}().",className,methodName);
        return result;
    }
}

