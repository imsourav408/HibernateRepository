package com.nt.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

import com.nt.entity.Entity;
import com.nt.entity.Patient;
import com.nt.util.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Entity entity=null;
		Session session=null;
		
		//get session object
		session=HibernateUtil.getSession();
		try {
			//load entity object
			entity=session.load(Patient.class,10001);
			if(entity==null) {
				System.out.println("Records not found");
			}
			else {
				System.out.println(
						"Entity class name: "+entity.getClass().getName()+"  Parent class name: "
								+entity.getClass().getSuperclass().getName()
								+" Parent Interfaces: "+Arrays.toString(entity.getClass().getInterfaces())
				);
				System.out.println("Records found");
				System.out.println(entity);
			}
		}
		catch (ObjectNotFoundException onfe) {
			System.out.println("Id is not available");
		}
		catch (HibernateException hbe) {
			hbe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//close session object
			HibernateUtil.closeSession(session);
			//close session factory object
			HibernateUtil.closeSessionFactory();
		}
	}
}
