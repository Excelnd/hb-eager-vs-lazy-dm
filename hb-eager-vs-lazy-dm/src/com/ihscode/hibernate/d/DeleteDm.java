package com.ihscode.hibernate.d;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ihscode.hibernate.d.entity.Instructor;
import com.ihscode.hibernate.d.entity.InstructorDetail;
import com.ihscode.hibernate.d.entity.Student;

public class DeleteDm {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session  = factory.getCurrentSession();
		
		try {

			// create the objects
//			Instructor tempInstructor =
//					new Instructor("Ihs", "Kla", "ihus@luv2code.com");
//			
//			InstructorDetail tempinstructorDetail =
//					new InstructorDetail(
//							"http://www.ihs2code.com/youtube",
//							"Luv 2 code!!!!!!");
			
			Instructor tempInstructor =
					new Instructor("Azhu", "Bhai", "azhu@luv2code.com");
			
			InstructorDetail tempinstructorDetail =
					new InstructorDetail(
							"http://www.youtube.com",
							"Sound Composing");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempinstructorDetail);
						
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will Also save the details object because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}
		finally {
			factory.close();
		}
					
				

	}

}
