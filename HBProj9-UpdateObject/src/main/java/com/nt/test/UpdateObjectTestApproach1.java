package com.nt.test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.util.HibernateUtil;

public class UpdateObjectTestApproach1 {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=null;
		boolean flag=false;
		try(factory;session){
			//full object modification
			Employee employee=new Employee();
			employee.setEno(1001);
			employee.setEname("Hritik");
			employee.setEadd("Balasore");
			employee.setDob(Date.valueOf("1999-12-30"));
			try {
				transaction=session.beginTransaction();
				session.update(employee);
				flag=true;
			}
			catch (HibernateException he) {
				flag=false;
				he.printStackTrace();
			}
			catch (Exception e) {
				flag=false;
				e.printStackTrace();
			}
			finally {
				if(flag) {
					transaction.commit();
					System.out.println("Object successfully updated");
				}
				else {
					transaction.rollback();
					System.out.println("Object updation failed");
				}
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
