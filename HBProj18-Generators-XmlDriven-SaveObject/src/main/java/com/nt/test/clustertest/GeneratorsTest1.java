package com.nt.test.clustertest;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class GeneratorsTest1 {

	public static void main(String[] args) {
		Session session=null;
		Employee employee=null;
		Transaction transaction=null;
		int eid=0;
		boolean flag=false;
		//create employee object having employee details
		employee=new Employee();
		employee.setEno(18726);
		employee.setEname("Murali");
		employee.setEadd("Talengana");
		employee.setDob(Date.valueOf("1988-10-02"));
		//get the session object
		session=HibernateUtil.getSession();
		try {
			//begin the transaction
			transaction=session.beginTransaction();
			//save the employee details to DB
			eid=(int)session.save(employee);
			System.out.println("Generated employee id: "+eid);
			flag=true;
			Thread.sleep(30000);
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object saved successfully");
			}
			else {
				transaction.rollback();
				System.out.println("Object saving failed");
			}
			//close the hibernate objects
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
