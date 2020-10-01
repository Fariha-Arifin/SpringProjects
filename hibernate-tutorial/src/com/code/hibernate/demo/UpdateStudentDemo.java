package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			// save student
			
			int id=1;
			
			Student myStudent = session.get(Student.class, id);
			
			System.out.println("Updating student...");
			myStudent.setLastName("kitty");
			// store the data into database
			
			System.out.println("Updating all student email...");
			session.createQuery("update Student set email='oo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
			
		}
		finally {
			factory.close();
		}

	}

}
