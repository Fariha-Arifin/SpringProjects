package com.code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Before("execution(* com.code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice()
	{
		System.out.println("Executing before advice on addAccount() method");
	}

}
