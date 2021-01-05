package com.nt.test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.util.HibernateUtil;

public class AnnotationSchemaGenerationTest {

	public static void main(String[] args) {
		Session session=null;
		Employee employee=null;
		Transaction transaction=null;
		boolean flag=false;
		int eid=0;
		//create employee object having employee details
		employee=new Employee();
		employee.setEno(100);
		employee.setEname("Sourav");
		employee.setEadd("Balasore");
		employee.setDob(Date.valueOf("1998-03-14"));
		employee.setJob("Analyst");
		employee.setSal(23000.33);
		//get session object
		session=HibernateUtil.getSession();
		try {
			transaction=session.beginTransaction();
			eid=(int)session.save(employee);
			System.out.println("Generated eid: "+eid);
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
				System.out.println("Employee details submited");
			}
			else {
				transaction.rollback();
				System.out.println("Employee details submission failed");
			}
		}
	}
}
