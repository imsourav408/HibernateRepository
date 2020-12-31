//This approach of using merge() is nothing but alternate to saveOrUpdate()
package com.nt.test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.util.HibernateUtil;

public class MergeObjectApproach1 {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		Employee employee=null,employee1=null;
		boolean flag=false;
		//create employee object having the employee details
		employee=new Employee();
		employee.setEno(1000);
		employee.setDob(Date.valueOf("1998-03-14"));
		employee.setEadd("Odisha");
		employee.setEname("Sourav");
		//get the session object
		session=HibernateUtil.getSession();
		try {
			//begin transaction
			transaction=session.beginTransaction();
			employee1=(Employee)session.merge(employee);
			System.out.println(employee1);
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
				System.out.println("Object saved or updated");
			}
			else {
				transaction.rollback();
				System.out.println("Object insertion or updation failed");
			}
			//close session object
			HibernateUtil.closeSession(session);
			//close factory object
			HibernateUtil.closeSessionFactory();
		}
	}
}