package com.code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticAspect {
	
	@Before("com.code.aopdemo.aspect.AopExpressions.forDaoPackageFinal()")
	public void performAPIanalytics()
	{
		System.out.println("Perform API analysis");
	}

}
