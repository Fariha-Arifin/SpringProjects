package com.code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatsillycoach")
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("practice")
	private FortuneService fortunservice;
	
	
	public TennisCoach()
	{
		System.out.println(">> default constructor here");
	}
	
	/*@Autowired
	public void  crazy(FortuneService theFortune)
	{
		System.out.println(">> setter injection here");
		this.fortunservice=theFortune;
	}
	*/
	
@PostConstruct
	public void doMystartupStaff()
	{
		System.out.println("inside of my doMystartupStaff method");
	}

@PreDestroy
public void doMyCleanupStaff()
{
	System.out.println("inside of my doMyCleanpStaff method");
}
  public String getDailyWork() {
		
		// TODO Auto-generated method stub
		return "coach method";
	}

	@Override
	public String getDailyWorkout() {
		
		// TODO Auto-generated method stub
		return "practine your backend volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortunservice.getFortune();
	}

}
