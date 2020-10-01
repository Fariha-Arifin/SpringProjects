package com.code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Practice implements FortuneService{

		 Random myrandom = new Random();
		String[] data = new String[100] ;
	 String theFortune;
	 String st; 
	 int count=-1;
	 @Override
		public String getFortune() {
		File file = new File("D:\\dest.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			  while ((st = br.readLine()) != null) 
			  {
				  data[++count] = st;
				  count++;
				  //System.out.println(st);
				  
			  }
			    
			    
		     br.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		int index = myrandom.nextInt(count);
	    theFortune = data[index];
	    return theFortune;
	}
}
