package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// Create session factory
				SessionFactory factory = new Configuration().configure("hibernate.ctg.xml")
						                 .addAnnotatedClass(Student.class)
						                 .buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				try {
					// create 3 student object
					System.out.println("create a student");
					Student tempstudent = new Student("Era","arifin","era@gmail.com");
					Student tempstudent1 = new Student("ra","arifin","ra@gmail.com");
					Student tempstudent2 = new Student("a","arifin","a@gmail.com");
					
					// start a transaction
					session.beginTransaction();
					// save student
					
					System.out.println("saving the student");
					session.save(tempstudent);
					session.save(tempstudent1);
					session.save(tempstudent2);
					// store the data into database
					
					session.getTransaction().commit();
					
					System.out.println("Done!!!");
					
					
				}
				finally {
					factory.close();
				}

			}

}
