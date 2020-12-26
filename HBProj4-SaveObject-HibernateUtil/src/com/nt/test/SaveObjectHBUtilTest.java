package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Patient;
import com.nt.util.HibernateUtil;

public class SaveObjectHBUtilTest {

	public static void main(String[] args) {
		Session session=null;
		Patient patient=null;
		Transaction transaction=null;
		boolean flag=false;
		int pid=0;
		
		//create patient object and set the details
		patient=new Patient();
		patient.setPname("Mohmad");
		patient.setPadd("Persian");
		patient.setPage(300);
		patient.setPsex("Male");
		patient.setPstage("Stage 3");
		
		//create session object
		session=HibernateUtil.getSession();
		try {
			//begin the transaction
			transaction=session.beginTransaction();
			pid=(int)session.save(patient);
			System.out.println("Generated Patient id: "+pid);
			flag=true;
		}
		catch (HibernateException hbe) {
			flag=false;
			hbe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("Patient Registration Succeded");
			}
			else {
				transaction.rollback();
				System.out.println("Patient Registration Faield");
			}
			//close session object
			HibernateUtil.closeSession(session);
			//close factory object
			HibernateUtil.closeFactory();
		}
	}
}