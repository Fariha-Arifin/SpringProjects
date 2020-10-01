package com.code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account acc, boolean a ) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
   public boolean doWork() {
		
		System.out.println(getClass() + ": DO work");
		return false;
		
	}
}