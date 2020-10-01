package com.code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune()
	{
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Heavy traffic in this morning";
	}

	public String getFortune(boolean tripwire) {
		if(tripwire) 
		{
			throw new RuntimeException("Accdental issue if roads are closed");
		}
		return getFortune();
	}

}
