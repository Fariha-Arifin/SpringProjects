package com.code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addSillyMember() {
		System.out.println(getClass() + "ADD membership DAO");
	}
	
	 public boolean GoSleep() {
			
			System.out.println(getClass() + ": Go Sleep");
			return false;
			
		}
}
