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
		String idVal=null;
		Transaction transaction=null;
		boolean flag=false;
		//create production object having all the details
		production=new Production();
		production.setPname("Laptops");
		production.setQty(5);
		production.setPrice(120053.33f);
		//get the session object
		session=HibernateUtil.getSession();
		try {
			//begin the transaction
			transaction=session.beginTransaction();
			idVal=(String)session.save(production);
			System.out.println("Generated id value is: "+idVal);
			flag=true;
		}
		catch (HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object insertion scccessfull");
			}
			else {
				transaction.rollback();
				System.out.println("Object insertion failed");
			}
			//close session
			HibernateUtil.closeSession(session);
			//close factory
			HibernateUtil.closeSessionFactory();
		}
	}
}
