package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Instructor;
import com.code.hibernate.demo.entity.InstructorDetails;

public class CreateDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.ctg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetails.class)
				                 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			Instructor tempInstructor = new Instructor("f","arifin");
			
			InstructorDetails tempInsDetails = new InstructorDetails("www.mmm,com","mosquto mara");
			
			tempInstructor.setInstructorDetails(tempInsDetails);
			// start a transaction
			session.beginTransaction();
			
			session.save(tempInstructor);
			
			// store the data into database
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
			
		}
		finally {
			factory.close();
		}

	}

}
