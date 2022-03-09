package com.learn2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
							
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			//start a transaction
			session.beginTransaction();
			
			//query the students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display query results
			displayStudents(theStudents);
			
			//query students by lastName
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			System.out.println("Stuents with lastname: Doe ");
			displayStudents(theStudents);
			
			//query OR
			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			System.out.println("Stuents with lastname: Doe or lastname : Daffy ");
			displayStudents(theStudents);
			
			//query LIKE
			theStudents = session.createQuery("from Student s where s.email LIKE '%luv2code.com' ").getResultList();
			System.out.println("Stuents with email ending with luv2code.com");
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
