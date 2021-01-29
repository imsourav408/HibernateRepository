package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Production;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		Session session=null;
		Production production=null;
		boolean flag=false;
		Transaction transaction=null;
		int idVal=0;
		//create production object having all the details
		production=new Production();
		production.setPname("Smart phones");
		production.setQty(15);
		production.setPrice(201203f);
		//get the session object
		session=HibernateUtil.getSession();
		try {
			//begin the transaction
			transaction=session.beginTransaction();
			//give persistence instruction
			idVal=(int)session.save(production);
			System.out.println("Generated id value is: "+idVal);
			flag=true;
		}
		catch (HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object saved successfully");
			}
			else {
				transaction.rollback();
				System.out.println("Object saving failed!!!");
			}
			//close session object
			HibernateUtil.closeSession(session);
			//close factory object
			HibernateUtil.closeSessionFcatory();
		}
	}
}
