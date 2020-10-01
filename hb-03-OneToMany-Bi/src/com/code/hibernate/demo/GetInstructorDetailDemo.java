package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Instructor;
import com.code.hibernate.demo.entity.InstructorDetails;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.ctg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetails.class)
				                 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int theId = 233;
			
			InstructorDetails tempins = session.get(InstructorDetails.class, theId);
			
			System.out.println("InstructorDetails" + tempins);
			
			//System.out.println("Associate Instructor" + tempins.getInstructor());
			
			
			// store the data into database
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
			
		}
		catch(Exception exp){
			exp.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
