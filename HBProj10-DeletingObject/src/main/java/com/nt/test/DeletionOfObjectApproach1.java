package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.util.HibernateUtil;

public class DeletionOfObjectApproach1 {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=null;
		boolean flag=false;
		Employee employee=null;
		try(factory;session){
			try {
				//begin the transaction
				transaction=session.beginTransaction();
				//create employee object having id value of the object to delete
				employee=new Employee();
				employee.setEno(1002);
				//delete the object
				session.delete(employee);
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
					System.out.println("Object deleted");
				}
				else {
					transaction.rollback();
					System.out.println("Object not deleted");
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
