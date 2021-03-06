package com.ihscode.hibernate.d;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ihscode.hibernate.d.entity.Course;
import com.ihscode.hibernate.d.entity.Instructor;
import com.ihscode.hibernate.d.entity.InstructorDetail;

public class CreateInstructorDm {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session  = factory.getCurrentSession();
		
		try {

			// create the objects
			Instructor tempInstructor =
					new Instructor("Adhu", "man", "adhu@luv2code.com");
			
			InstructorDetail tempinstructorDetail =
					new InstructorDetail(
							"http://www.youtube.com",
							"Video Games");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempinstructorDetail);
			
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);				
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
					
				

	}

}