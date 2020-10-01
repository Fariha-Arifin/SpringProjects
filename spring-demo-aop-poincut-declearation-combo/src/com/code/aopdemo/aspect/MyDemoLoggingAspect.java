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
	
	@Pointcut("execution(* com.code.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.code.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageFinal() {}
	
	@Before("forDaoPackageFinal()")
	public void performAPIanalytics()
	{
		System.out.println("Perform API analysis");
	}

}
