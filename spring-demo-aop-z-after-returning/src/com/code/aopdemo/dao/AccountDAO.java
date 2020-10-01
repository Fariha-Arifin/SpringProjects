package com.code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String field;
	
	public List<Account> findAccount()
	{
		List<Account> myAccount = new ArrayList<>();
		
		Account acc1 = new Account("ss","teacher");
		Account acc2 = new Account("yy","jharudar");
		Account acc3 = new Account("zz","pani puri");
		
		myAccount.add(acc1);
		myAccount.add(acc2);
		myAccount.add(acc3);
		
		return myAccount;
	}

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