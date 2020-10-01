package com.code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aopdemo.dao.AccountDAO;
import com.code.aopdemo.dao.MembershipDAO;
import com.code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		//AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain program around demo app");
		
		System.out.println("\nCalling get fortune");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("\n My fortune today : " + data);
		
		System.out.println("\n Finished");
		
		// close the context
		context.close();
	}

}
