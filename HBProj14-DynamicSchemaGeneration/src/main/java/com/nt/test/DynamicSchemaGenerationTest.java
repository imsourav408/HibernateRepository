package com.nt.test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Production;
import com.nt.util.HibernateUtil;

public class DynamicSchemaGenerationTest {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		int pid=0;
		boolean flag=false;
		Production production=null;
		
		//create Production object and set the field values
		production=new Production();
		production.setPname("Laptops");
		production.setPdate(Date.valueOf("2020-11-10"));
		//get Session object
		session=HibernateUtil.getSession();
		try {
			transaction=session.beginTransaction();
			pid=(int)session.save(production);
			System.out.println("Generated patient id: "+pid);
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
				System.out.println("Data insert successfull");
			}
			else {
				transaction.rollback();
				System.out.println("Insertion failed");
			}
			//close session object
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
