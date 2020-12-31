package com.nt.test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.util.HibernateUtil;

public class SaveOrUpdateObjectTest {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		Employee employee=null;
		boolean flag=false;
		//create employee object with employee details 
		employee=new Employee();
		/*	if generator is configure and record is not available then 
		 *	generator generated id and setter id values must same otherwise exception will raised
		*/
		employee.setEno(1011);
		employee.setEname("Nitish Rana");
		employee.setEadd("Hariyana");
		employee.setDob(Date.valueOf("1993-09-19"));
		//get Session object
		session=HibernateUtil.getSession();
		try {
			transaction=session.beginTransaction();
			session.saveOrUpdate(employee);
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
				System.out.println("Object is saved or updated");
			}
			else {
				transaction.rollback();
				System.out.println("Object save or updation failed");
			}
			//close session object
			HibernateUtil.closeSession(session);
			//close factory object
			HibernateUtil.closeSessionFactory();
		}
	}
}