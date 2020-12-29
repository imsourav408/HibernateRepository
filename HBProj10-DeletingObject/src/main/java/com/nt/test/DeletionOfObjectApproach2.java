package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.util.HibernateUtil;

public class DeletionOfObjectApproach2 {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=null;
		boolean flag=false;
		Employee employee=null;
		try(factory;session){
			//get the employee object
			employee=session.get(Employee.class,1004);
			try {
				//begin the transaction
				transaction=session.beginTransaction();
				if(employee!=null) {
					session.delete(employee);
					flag=true;
				}
				else {
					System.out.println("Record not found");
					flag=false;
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
					transaction.commit();
					System.out.println("Object deleted");
				}
				else {
					transaction.rollback();
					System.out.println("Object deletion failed");
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
