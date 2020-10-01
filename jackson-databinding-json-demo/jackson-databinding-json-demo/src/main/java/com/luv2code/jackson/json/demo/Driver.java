package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			Student mystudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			System.out.println("First Name : " + mystudent.getFirstName());
			System.out.println("Last Name : " + mystudent.getLastName());
			
			Address tempaddress = mystudent.getAddress();
			System.out.println("Street : " + tempaddress.getStreet());
			System.out.println("City : " + tempaddress.getCity());
			
			for(String templang : mystudent.getLanguages())
			{
				System.out.println(templang);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
