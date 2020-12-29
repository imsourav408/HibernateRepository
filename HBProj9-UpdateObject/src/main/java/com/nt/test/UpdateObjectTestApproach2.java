package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.util.HibernateUtil;

public class UpdateObjectTestApproach2 {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=null;
		boolean flag=false;
		Employee employee=null;
		try(factory;session){
			try {
				employee=session.get(Employee.class,1001);
				if(employee!=null) {
					transaction=session.beginTransaction();
					//modify partial object
					employee.setEname("Hritik");
					session.update(employee);
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
					transaction.commit();
					System.out.println("Object successfully updated");
				}
				else {
					transaction.rollback();
					System.out.println("Object updation failed");
				}
			}
		}
		catch (HibernateException hbe) {
			hbe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
