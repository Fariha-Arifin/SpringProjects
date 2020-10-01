package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Course;
import com.code.hibernate.demo.entity.Instructor;
import com.code.hibernate.demo.entity.InstructorDetails;
import com.code.hibernate.demo.entity.Review;
import com.code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			Course tempcourse = new Course("fawl book");
		
			System.out.println("Saving the course");
			session.save(tempcourse);
			System.out.println("Save course: "+ tempcourse);
			
			Student tempstudent1 = new Student("st3","3","st3@mail.com");
			Student tempstudent2 = new Student("st4","4","st4@mail.com");
			
	        tempcourse.addStudent(tempstudent1);
			tempcourse.addStudent(tempstudent2);
			
			System.out.println("Saving the Students");
			session.save(tempstudent1);
			session.save(tempstudent2);
			System.out.println(tempcourse.getStudents());
			
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
