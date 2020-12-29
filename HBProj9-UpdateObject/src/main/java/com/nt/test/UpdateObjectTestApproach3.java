package com.nt.test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.util.HibernateUtil;

public class UpdateObjectTestApproach3 {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=null;
		boolean flag=false;
		Employee employee=null;
		try(factory;session){
			try {
				employee=session.get(Employee.class,1003);
				if(employee!=null) {
					transaction=session.beginTransaction();
					employee.setDob(Date.valueOf("1998-03-03"));
					flag=true;
				}
				else {
					System.out.println("Record not found");
					return;
				}
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
					if(transaction!=null) {
						transaction.commit();
						System.out.println("Object successfully updated");
					}
				}
				else {
					if(transaction!=null)
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
