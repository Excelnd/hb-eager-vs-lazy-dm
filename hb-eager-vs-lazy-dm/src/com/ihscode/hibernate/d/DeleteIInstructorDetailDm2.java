package com.ihscode.hibernate.d;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ihscode.hibernate.d.entity.Instructor;
import com.ihscode.hibernate.d.entity.InstructorDetail;
import com.ihscode.hibernate.d.entity.Student;

public class DeleteIInstructorDetailDm2 {

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

			// start a transaction
			session.beginTransaction();

			// get the instructor detail object
			int theId = 299;
			InstructorDetail tempinstructorDetail =
					session.get(InstructorDetail.class, theId);
			
			// print the instructor detail			
			System.out.println("InstructorDetail" + tempinstructorDetail);
			
			// print the associated instructor
			System.out.println("tempInstructorDetail: " + tempinstructorDetail);
						
			// Delete the instructor detail
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
					
				

	}

}
