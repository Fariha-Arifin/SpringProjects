package com.code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = new 
				AnnotationConfigApplicationContext(SportConfig.class);
		
		Coach thecoach = context.getBean("tennisCoach",Coach.class);
		
		System.out.println(thecoach.getDailyWorkout());
		
		context.close();
		
		
	}

}
