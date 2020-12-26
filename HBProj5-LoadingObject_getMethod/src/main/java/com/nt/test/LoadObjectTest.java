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
			//load object
			patient=session.get(Patient.class,10006);
			//verify 
			if(patient==null)
				System.out.println("Result not found");
			else {
				System.out.println("Records found");
				System.out.println(patient);
			}
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