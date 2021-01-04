package com.nt.test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.util.HibernateUtil;

public class AnnoSaveObjectTest {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		Employee employee=null;
		boolean flag=false;
		int eid=0;
		
		//create employee object with employee details
		employee=new Employee();
		employee.setEno(1012);
		employee.setEname("Nabdeep Saini");
		employee.setEadd("Bangalore");
		employee.setDob(Date.valueOf("1994-11-14"));
		//get Session object
		session=HibernateUtil.getSession();
		try {
			//begin the transaction
			transaction=session.beginTransaction();
			eid=(int)session.save(employee);
			System.out.println("Generated eid is: "+eid);
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
				System.out.println("Insertion complete");
			}
			else {
				transaction.rollback();
				System.out.println("Insertion failed");
			}
			//close session object
			HibernateUtil.closeSession(session);
			//close session factory object
			HibernateUtil.closeSessionFactory();
		}
	}
}