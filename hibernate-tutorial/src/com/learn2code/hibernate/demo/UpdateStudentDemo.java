package com.learn2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
							
		
		
		try {
			
			int studentId = 1;
			
			//create session
			Session session = factory.getCurrentSession();

			//start a transaction
			session.beginTransaction();
			
			//retrieve the student based on the id: primary key
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student...");
			myStudent.setFirstName("Scooby");
			//commit transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("Update email for all students..");
			
			session.createQuery("update Student set email='foo@gmail.com' ").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
	}

}
