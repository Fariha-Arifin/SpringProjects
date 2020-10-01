package com.code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.practice.ctg2.xml")
			                        .addAnnotatedClass(Employee.class)
			                        .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
					
			session.beginTransaction();
			
			session.createQuery("delete from Employee where lastName='c' ").executeUpdate();
			
				
			session.getTransaction().commit();
			
		}
		finally{
			factory.close();
		}
		 

	}


}
