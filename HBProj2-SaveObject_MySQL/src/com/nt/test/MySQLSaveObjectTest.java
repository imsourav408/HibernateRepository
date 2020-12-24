package com.nt.test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Student;

public class MySQLSaveObjectTest {

	public static void main(String[] args) {
		Configuration configuration=null;
		SessionFactory factory=null;
		Session session=null;
		Transaction transaction=null;
		Student student=null;
		boolean flag=false;
		int sid=0;
		
		//create student object having student details
		student=new Student();
		student.setSname("Shivam Kumar Jha");
		student.setSadd("Remuna");
		student.setDob(Date.valueOf("1998-10-18"));
		student.setSmark(450.0f);
		student.setTmark(600f);
		
		//create configuration object and bootstrap hibernate
		configuration=new Configuration();
		//provide configuration file location
		configuration.configure("com/nt/cfgs/hibernate.cfg.xml");
		//create session factory object
		factory=configuration.buildSessionFactory();
		//create session object
		session=factory.openSession();
		try {
			//begins the transaction by passing con.setAutoCommit(false)
			transaction=session.beginTransaction();
			//give save object permission
			sid=(int)session.save(student);
			System.out.println("Return back student id: "+sid);
			System.out.println("Generated student id: "+student.getSno());
			flag=true;
		}
		catch(HibernateException hbe) {
			flag=false;
			hbe.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("Record successfully inserted");
			}
			else {
				transaction.rollback();
				System.out.println("Record insertion failed");
			}
			//close session object
			session.close();
			//close session factory object
			factory.close();
		}
	}
}