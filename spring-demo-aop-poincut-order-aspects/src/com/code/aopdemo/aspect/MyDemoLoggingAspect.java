package com.code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	@Before("com.code.aopdemo.aspect.AopExpressions.forDaoPackageFinal()")
	public void beforeAddAccountAdvice()
	{
		System.out.println("Performing Account Advice");
	}
	

}
