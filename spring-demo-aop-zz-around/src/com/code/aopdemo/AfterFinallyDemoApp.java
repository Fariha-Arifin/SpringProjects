package com.code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aopdemo.dao.AccountDAO;
import com.code.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		//AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> listAcc = null;
		
		try {
			
			boolean tripwire = false;
			listAcc = theAccountDAO.findAccount(tripwire);
		}
		catch(Exception exc){
			System.out.println("Main programe catch excption !!!");
		}
		
		
		System.out.println("Main programe after throwing exception");

		System.out.println(listAcc);

		
				
		// close the context
		context.close();
	}

}
