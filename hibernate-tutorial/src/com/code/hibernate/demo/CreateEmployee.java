package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.practice.ctg2.xml")
			                        .addAnnotatedClass(Employee.class)
			                        .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			Employee emp1 = new Employee("a","b","ab");
			
			session.beginTransaction();
			session.save(emp1);
			session.getTransaction().commit();
			
		}
		finally{
			factory.close();
		}
		 

	}

}
