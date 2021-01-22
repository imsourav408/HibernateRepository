package com.nt.test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class GeneratorsBatchTest {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		Employee employee=null;
		boolean flag=false;
		int eid=0;
		//get the session object
		session=HibernateUtil.getSession();
		try {
			//begin the transaction
			transaction=session.beginTransaction();
			for(int i=0;i<20;i++) {
				employee=new Employee();
				employee.setEno(10323);
				employee.setEname("Raju");
				employee.setEadd("Lucknow");
				employee.setDob(Date.valueOf("1992-12-12"));
				eid=(int)session.save(employee);
				System.out.println("Generated employee id: "+eid);
			}
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
				System.out.println("Objects are successfully saved");
			}
			else {
				transaction.rollback();
				System.out.println("Objects are not saved successfully");
			}
			//close the hibernate objects
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
