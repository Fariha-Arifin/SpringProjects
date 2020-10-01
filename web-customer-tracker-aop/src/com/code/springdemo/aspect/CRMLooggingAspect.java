package com.code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLooggingAspect {

	@Pointcut("execution(* com.code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	
	@Pointcut("execution(* com.code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	@Pointcut("execution(* com.code.springdemo.service.*.*(..))")
	private void forServicePackage() {
		
	}
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void forAppFlow() {
		
	}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint)
	{
		String themethod = theJoinPoint.getSignature().toShortString();
		System.out.println("==> @Before calling method" + themethod);
		
        Object[] args = theJoinPoint.getArgs();
		
		for(Object theargs : args)
		{
			System.out.println("Method Arguments" + theargs );
			
		}
		
	}
	
	
	@AfterReturning(pointcut = "forAppFlow()",returning = "result")
	public void after(JoinPoint theJoinPoint , Object result)
	{
		String themethod = theJoinPoint.getSignature().toShortString();
		System.out.println("==> @AfterReturning calling method" + themethod);
		
		System.out.println("==> @AfterReturning result" + result);
		
       
		
	}
	
	
}
