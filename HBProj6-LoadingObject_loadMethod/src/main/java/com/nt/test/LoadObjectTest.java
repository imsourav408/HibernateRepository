package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Patient;
import com.nt.util.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Patient patient=null;
		Session session=null;
		
		//get session object
		session=HibernateUtil.getSession();
		try {
			//load patient object from d/b
			patient=session.load(Patient.class,10001);
			if(patient==null)
				System.out.println("Record not found");
			//do this operation by changing lazy attribute from true to false and vice versa in mapping file class tag
			System.out.println("Entity class name: "+patient.getClass().getName()+" Parent class name "+patient.getClass().getSuperclass().getName());
			System.out.println("Records are:");
			System.out.println(patient);
		}
		catch (org.hibernate.ObjectNotFoundException onf) {
			System.out.println("Records not found");
		}
		catch (HibernateException hbe) {
			hbe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//close session object
			HibernateUtil.closeSession(session);
			//close factory object
			HibernateUtil.closeSessionFactory();
		}
	}

}
