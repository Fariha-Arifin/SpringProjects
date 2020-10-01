package com.code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Employee;

public class QueryEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.practice.ctg2.xml")
			                        .addAnnotatedClass(Employee.class)
			                        .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
					
			session.beginTransaction();
			
			List<Employee> tmpemp = session.createQuery("from Employee as e where e.company='dd' ").list();
			
			display(tmpemp);
			
			session.getTransaction().commit();
			
		}
		finally{
			factory.close();
		}
		 

	}

	private static void display(List<Employee> tmpemp) {
		for(Employee emp : tmpemp)
		{
			System.out.println(emp);
		}
	}

}
