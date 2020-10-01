package com.code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.XML");
		
		Coach thecoach = context.getBean("tennisCoach",Coach.class);
		
		Coach alphacoach = context.getBean("tennisCoach",Coach.class);
		
		boolean result = (thecoach == alphacoach);
		
		System.out.println("\n if result are in same location" + result);
		System.out.println("\n memory location thecoach" + thecoach);
		System.out.println("\n memory location alphacoach" + alphacoach);
		
		context.close();
		
		
	}

}
