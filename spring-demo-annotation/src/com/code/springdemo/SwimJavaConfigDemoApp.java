package com.code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = new 
				AnnotationConfigApplicationContext(SportConfig.class);
		
		SwimCoach thecoach = context.getBean("sCoach",SwimCoach.class);
		
		System.out.println(thecoach.getDailyWorkout());
		System.out.println(thecoach.getDailyFortune());
		
		System.out.println("Email : " + thecoach.getEmail());
		System.out.println("Team : " + thecoach.getTeam());
		
		context.close();
		
		
	}

}
