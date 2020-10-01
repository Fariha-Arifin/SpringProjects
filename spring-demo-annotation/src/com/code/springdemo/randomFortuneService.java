package com.code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class randomFortuneService implements FortuneService {
	
	private String[] data = {
			"hello one",
			"hello two",
			"hello three"	
	};
	
	private Random myrandom = new Random();

	@Override
	public String getFortune() {


		int index = myrandom.nextInt(data.length);
		String theFortune = data[index];
		
		return theFortune;
	}

}
