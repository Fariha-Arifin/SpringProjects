package com.code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice()
	{
		System.out.println("Executing before advice on addAccount() method");
	}
	
	@Before("forDaoPackage()")
	public void performAPIanalytics()
	{
		System.out.println("Perform API analysis");
	}

}
