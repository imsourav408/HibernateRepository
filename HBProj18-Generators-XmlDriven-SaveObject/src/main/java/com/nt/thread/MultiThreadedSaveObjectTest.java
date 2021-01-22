package com.nt.thread;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class MultiThreadedSaveObjectTest {

	public static void main(String[] args) throws InterruptedException{
		Runnable runnable1=null,runnable2=null,runnable3=null;
		Thread t1=null,t2=null,t3=null;
		//create employee objects having employee details
		//employee 1
		Employee employee1=new Employee();
		employee1.setEno(20000);
		employee1.setEname("Sanskruti");
		employee1.setEadd("Hyderabad");
		employee1.setDob(Date.valueOf("2000-11-11"));
		//employee 2
		Employee employee2=new Employee();
		employee2.setEno(20032);
		employee2.setEname("Mukesh");
		employee2.setEadd("Benglore");
		employee2.setDob(Date.valueOf("1998-10-11"));
		//employee 3
		Employee employee3=new Employee();
		employee3.setEno(13442);
		employee3.setEname("Chari");
		employee3.setEadd("Odisha");
		employee3.setDob(Date.valueOf("1997-09-08"));
		//get the session object
		Session session1=HibernateUtil.getSession();
		Session session2=HibernateUtil.getSession();
		Session session3=HibernateUtil.getSession();
		//create the runnable objects with our task
		runnable1=()->{
			Transaction transaction=null;
			boolean flag=false;
			int eid=0;
			try {
				//begin the transaction
				transaction=session1.beginTransaction();
				eid=(int)session1.save(employee1);
				System.out.println("Generated employee id: "+eid);
				flag=true;
			}
			catch (HibernateException he) {
				flag=false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if(flag) {
					transaction.commit();
					System.out.println("Object saved sucessfully");
				}
				else {
					transaction.rollback();
					System.out.println("Object saving failed");
				}
			}
			//close the session object
			HibernateUtil.closeSession(session1);
		};
		runnable2=()->{
			Transaction transaction=null;
			boolean flag=false;
			int eid=0;
			try {
				//begin the transaction
				transaction=session2.beginTransaction();
				eid=(int)session2.save(employee2);
				System.out.println("Generated employee id: "+eid);
				flag=true;
			}
			catch (HibernateException he) {
				flag=false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if(flag) {
					transaction.commit();
					System.out.println("Object saved sucessfully");
				}
				else {
					transaction.rollback();
					System.out.println("Object saving failed");
				}
				//close the session object
				HibernateUtil.closeSession(session2);
			}
		};
		runnable3=()->{
			Transaction transaction=null;
			boolean flag=false;
			int eid=0;
			try {
				//begin the transaction
				transaction=session3.beginTransaction();
				eid=(int)session3.save(employee3);
				System.out.println("Generated employee id: "+eid);
				flag=true;
			}
			catch (HibernateException he) {
				flag=false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if(flag) {
					transaction.commit();
					System.out.println("Object saved sucessfully");
				}
				else {
					transaction.rollback();
					System.out.println("Object saving failed");
				}
				//close the session object
				HibernateUtil.closeSession(session3);
			}
		};
		//create thread object with passing runnable objects
		t1=new Thread(runnable1);
		t2=new Thread(runnable2);
		t3=new Thread(runnable3);
		//start the threads
		t1.start();t2.start();t3.start();
		Thread.sleep(6000);
		//close factory object
		HibernateUtil.closeSessionFactory();
	}
}
