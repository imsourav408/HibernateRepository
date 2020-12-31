package com.nt.test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.util.HibernateUtil;

public class MergeObjectApproach2 {

	public static void main(String[] args) {
		Session session=null;
		Employee employee=null,employee1=null,employee2=null;
		Transaction transaction=null;
		boolean flag=false;
		//create employee object with same id value to be loaded and different other properties values
		employee=new Employee();
		employee.setEno(1000);
		employee.setEname("Kartik");
		employee.setEadd("Chennai");
		employee.setDob(Date.valueOf("1987-11-10"));
	
		//get session object
		session=HibernateUtil.getSession();
		//load the entity object having id 1000
		employee1=(Employee)session.get(Employee.class,1000);
		try {
			//begin the transaction
			transaction=session.beginTransaction();
		//	session.update(employee);	//throws org.hibernate.NonUniqueObjectException
		//	session.save(employee);		//throws org.hibernate.NonUniqueObjectException
		//	session.saveOrUpdate(employee);	//throws org.hibernate.NonUniqueObjectException
		//	session.delete(employee);	//throws javax.persistence.EntityExistsException
			employee2=(Employee)session.merge(employee);
			System.out.println(employee2);
			System.out.println(employee.hashCode()+"  "+employee1.hashCode()+"  "+employee2.hashCode());
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
				System.out.println("Operation successful");
			}
			else {
				transaction.rollback();
				System.out.println("Operation failed");
			}
			//close session object
			HibernateUtil.closeSession(session);
			//close factory object
			HibernateUtil.closeSessionFactory();
		}
	}

}
