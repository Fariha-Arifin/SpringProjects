package com.code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.code.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	@AfterReturning(pointcut="execution(* com.code.aopdemo.dao.AccountDAO.findAccount(..))",
			        returning="result")
	
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint ,
			 List<Account> result)
	 
	{
		String method = theJoinPoint.getSignature().toString();
		System.out.println("Executing After Returning on  method : " + method);
		
		System.out.println("Result : " + result);
		
		convertDataIntoUpperCase(result);
		
		System.out.println("Result : " + result);
		
		
	}
	
	private void convertDataIntoUpperCase(List<Account> result) {
		
		for(Account tempResult : result)
		{
			String upperCase = tempResult.getName().toUpperCase();
			tempResult.setName(upperCase);
			
		}
		
	}

	@Before("com.code.aopdemo.aspect.AopExpressions.forDaoPackageFinal()")
	public void beforeAddAccountAdvice(JoinPoint theJointPoint)
	{
		System.out.println("Performing Account Advice");
		
		MethodSignature thesignature = (MethodSignature) theJointPoint.getSignature();
		
		System.out.println("Method Signature:" + thesignature );
		
		Object[] args = theJointPoint.getArgs();
		
		for(Object theargs : args)
		{
			System.out.println("Method Arguments" + theargs );
			
			if(theargs instanceof Account)
			{
				Account theacc = (Account) theargs;
				System.out.println("Account Name" + theacc.getName() );
				System.out.println("Account Level" + theacc.getLevel() );
			}
		}
		
		
		
		
	}
	

}
