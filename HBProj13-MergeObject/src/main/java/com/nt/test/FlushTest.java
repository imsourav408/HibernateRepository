/*
 * for testing this class make sure hibernate 4.x is added to classpath
 * without using transaction we can proceed non-select operation using session.flush()
 * but from hibernate 5.x onwards it is mandatory to proceed non-select operations with transaction
 * otherwise it throws javax.persistence.TransactionRequiredException: no transaction is in progress
 * 
 */
package com.nt.test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Employee;
import com.nt.util.HibernateUtil;

public class FlushTest {

	public static void main(String[] args) {
		Session session=null;
		Employee employee=null;
		int eid=0;
		//create employee object having employee details
		employee=new Employee();
		employee.setEno(1011);
		employee.setEname("Sourav Ganguly");
		employee.setEadd("Kolkata");
		employee.setDob(Date.valueOf("1983-08-12"));
		//get session object
		session=HibernateUtil.getSession();
		try {
			eid=(int)session.save(employee);
			System.out.println("Generator id value is: "+eid);
			session.flush();
		}
		catch (HibernateException he) {
			he.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//close session object
			HibernateUtil.closeSession(session);
			//close factory object
			HibernateUtil.closeSessionFactory();
		}
	}
}
