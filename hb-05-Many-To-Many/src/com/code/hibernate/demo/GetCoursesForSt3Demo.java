package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Course;
import com.code.hibernate.demo.entity.Instructor;
import com.code.hibernate.demo.entity.InstructorDetails;
import com.code.hibernate.demo.entity.Review;
import com.code.hibernate.demo.entity.Student;

public class GetCoursesForSt3Demo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.ctg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetails.class)
				                 .addAnnotatedClass(Course.class)
				                 .addAnnotatedClass(Review.class)
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			int theid=3;
			
			Student tempstudent = session.get(Student.class, theid);
			
			System.out.println("Getting the Student");
			System.out.println("Getting the courses of the student: "+tempstudent.getCourses());
			
			
			// store the data into database
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
			
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
