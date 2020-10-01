package com.code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aopdemo.dao.AccountDAO;
import com.code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		//AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		Account acc = new Account();
		acc.setName("Fariha");
		acc.setLevel("12");
		
		// call the business method
		theAccountDAO.addAccount(acc, true);
		theAccountDAO.doWork();
		
		theAccountDAO.setName("foobar");
		theAccountDAO.setField("cricket field");
		
		String name = theAccountDAO.getName();
		String field = theAccountDAO.getField();
		
		theMembershipDAO.addSillyMember();
		theMembershipDAO.GoSleep();

		
				
		// close the context
		context.close();
	}

}
