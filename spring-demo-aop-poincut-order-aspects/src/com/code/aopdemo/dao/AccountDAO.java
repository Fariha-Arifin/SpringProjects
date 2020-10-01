package com.code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String field;

	public void addAccount(Account acc, boolean a ) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
   public boolean doWork() {
		
		System.out.println(getClass() + ": DO work");
		return false;
		
	}

	public String getName() {
		System.out.println(getClass() + ": in getName");
		return name;
	}
	
	public void setName(String name) {
		System.out.println(getClass() + ": in setName");
		this.name = name;
	}
	
	public String getField() {
		System.out.println(getClass() + ": in getField");
		return field;
	}
	
	public void setField(String field) {
		System.out.println(getClass() + ": in setField");
		this.field = field;
	}
   
   
}