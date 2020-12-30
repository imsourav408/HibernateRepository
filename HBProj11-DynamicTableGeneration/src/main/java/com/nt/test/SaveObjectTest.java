package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Project;
import com.nt.util.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=null;
		boolean flag=false;
		Project project=null;
		long pid=0;
		try(factory;session){
			//create entity object having data
			project=new Project();
			project.setProjId(1001l);
			project.setProjName("Java");
			project.setTeamSize(12);
			try {
				//begin the transaction
				transaction=session.beginTransaction();
				pid=(long)session.save(project);
				System.out.println("Generated projet id: "+pid);
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
					System.out.println("Record successfully inserted");
				}
				else {
					transaction.rollback();
					System.out.println("Record insertion failed");
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
