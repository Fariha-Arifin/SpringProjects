package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			System.out.println("Deleting student...");
			session.delete(myStudent);
			// store the data into database
			
			System.out.println("Updating all student email...");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
			
		}
		finally {
			factory.close();
		}

	}

}
