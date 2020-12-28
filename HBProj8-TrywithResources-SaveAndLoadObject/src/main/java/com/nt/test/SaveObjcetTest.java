package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Patient;
import com.nt.util.HibernateUtil;

public class SaveObjcetTest {

	public static void main(String[] args) {
		Transaction transaction=null;
		int pid=0;
		boolean flag=false;
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Patient patient=null;
		//try with java 9 feature
		try(factory;session){
			patient=new Patient();
			patient.setPname("Sidharth");
			patient.setPage(30);
			patient.setPsex("male");
			try {
				transaction=session.beginTransaction();
				pid=(int)session.save(patient);
				System.out.println("Generated patient id: "+pid);
				flag=true;
			}
			catch (HibernateException he) {
				flag=false;
				he.printStackTrace();
			}
			finally {
				if(flag) {
					transaction.commit();
					System.out.println("Record Inserted");
				}
				else {
					transaction.rollback();
					System.out.println("Record Insertion Failed");
				}
			}
		}
		catch (HibernateException hbe) {
			hbe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
