package com.code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-04-one-to-many-uni?useSSL=false";
		String user = "mvcStudent";
		String pass = "mvcStudent";
		
		try {
			System.out.println("Connecting database" + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connecting successful!!!");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
