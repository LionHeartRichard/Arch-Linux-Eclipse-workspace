package com.hibernatemvc.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

	@Around("execution(* com.hibernatemvc.model.dao.*.*(..))")
	public Object aroundAllRepositoryMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
		String methodName = methodSignature.getName();

		System.out.println("__Begin method - " + methodName);
		Object targetMethodResult = proceedingJoinPoint.proceed();
		System.out.println("__END method - " + methodName);

		return targetMethodResult;
	}
}
