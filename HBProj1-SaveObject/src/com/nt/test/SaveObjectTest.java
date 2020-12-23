package com.nt.test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Student;

public class SaveObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Student student=null;
		Transaction tx=null;
		boolean flag=false;
		int idval=0;
		//Activate Hibernate f/w (BootStrap hibernate)
		cfg=new Configuration();
		System.out.println(cfg.getProperties());
		System.out.println("...........................");
		//supply hiberante cfg file as input file
		cfg.configure("com/nt/cfg/hibernate.cfg.xml");
		// cfg.configure();
		System.out.println(cfg.getProperties());
		//build Session Factory
		factory=cfg.buildSessionFactory();
		System.out.println("sessionFactory object class name::"+factory.getClass());
		//open Session
		ses=factory.openSession();
		System.out.println("session object class name::"+ses.getClass());
		//create Entity  object to save with Db s/w
		student=new Student();
		student.setSno(18);
		student.setSname("Virat Kohli");
		student.setSadd("Delhi");
		student.setDob(Date.valueOf("1991-08-12"));
		student.setSmark(540f);
		student.setTmark(600f);
		student.setCgpa(9.5f);
		try {
			tx=ses.beginTransaction();    //internally calls  con.setAutoCommit(false) to begin the Tx
			System.out.println("tx objecct class name::"+tx.getClass());
			//save object
			idval=(int)ses.save(student);
			System.out.println("Generated id value ::"+idval);
			flag=true;
			System.out.println("id value ::"+student.getSno());
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			//commit or rollback  Tx
			if(flag==true) {
				tx.commit();  //internally calls con.commit()
			    System.out.println("Object is saved");	
			}
			else {
		    	tx.rollback(); //internally calls  con.rollback()
		    	 System.out.println("Object is not saved");
		    }
			//close  session object
		    ses.close();
		    //close SessionFactroy
   		    factory.close();
		}//finally  */
	}
}
