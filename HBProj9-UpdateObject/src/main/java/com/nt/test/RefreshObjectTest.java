package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Employee;
import com.nt.util.HibernateUtil;

public class RefreshObjectTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Employee employee=null;
		try(factory;session){
			employee=session.get(Employee.class,1003);
			if(employee!=null) {
				System.out.println("Object before modification");
				System.out.println(employee);
				try {
					Thread.sleep(30000);	//modify db table record using SQL prompt or SQL developer
					session.refresh(employee);	//Db table row  to Entity object sync
					System.out.println("Object after modification");
					System.out.println(employee);
				}
				catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
			else {
				System.out.println("Record not found");
				return;
			}
		}
		catch (HibernateException he) {
			he.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
