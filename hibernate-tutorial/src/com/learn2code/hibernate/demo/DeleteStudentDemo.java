package com.learn2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
							
		
		
		try {
			
			
			//create session
			Session session = factory.getCurrentSession();

			session.beginTransaction();
			
			int studentId = 1;
			
			Student myStudent = session.get(Student.class, studentId);
			//delete a student object
			System.out.println("Deleting student with id 2.. " );
			
			//session.delete(myStudent);
			session.createQuery("delete Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
	}

}
