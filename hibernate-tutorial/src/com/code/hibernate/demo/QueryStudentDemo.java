package com.code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.ctg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			//Query student
			List<Student> thestudent = session.createQuery("from Student").list();
			
			
			// Display student
			displayStudent(thestudent);
			
			//Query student
			thestudent = session.createQuery("from Student s where s.lastName='arifin'").list();
			
			System.out.println("Students who have last name of arifin");
			displayStudent(thestudent);
			
			thestudent = session.createQuery("from Student s where"
					+ " s.lastName='arifin' OR s.firstName='ra'").list();
			
			System.out.println("Students who have last name of arifin and first name Era");
			displayStudent(thestudent);
			
			thestudent = session.createQuery("from Student s where"
					+ " s.email LIKE '%era@gmail.com'").list();
			
			System.out.println("Students who have email era@ggmil.com");
			displayStudent(thestudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
			
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudent(List<Student> thestudent) {
		for(Student tempstudent : thestudent)
		{
			System.out.println(tempstudent);
		}
	}

}
