package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Employee;

public class ReadEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.practice.ctg2.xml")
			                        .addAnnotatedClass(Employee.class)
			                        .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			Employee emp1 = new Employee("d","d","dd");
			
			session.beginTransaction();
			session.save(emp1);
			
			Employee remp = session.get(Employee.class, emp1.getFirstName());
			System.out.println(emp1.getLastName());
			System.out.println(" Employee data read : " + remp);
			
			session.getTransaction().commit();
			
		}
		finally{
			factory.close();
		}
		 

	}

}
