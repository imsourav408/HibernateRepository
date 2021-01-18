package com.nt.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

import com.nt.entity.Employee;
import com.nt.entity.Entity;
import com.nt.util.HibernateUtil;

public class AnnoLoadObjectTest {

	public static void main(String[] args) {
		Session session=null;
		Entity entity=null;
		try {
			//get session object
			session=HibernateUtil.getSession();
			//load the object from database
			entity=session.load(Employee.class,1000);
			if(entity==null)
				System.out.println("Record not found");
			else {
				System.out.println("Entity class name: "
						+entity.getClass().getName()
						+" entity class super class: "+entity.getClass().getSuperclass().getName()
						+" entity Interfaces: "+Arrays.toString(entity.getClass().getInterfaces())
				);
				System.out.println("Loaded object  details: ");
				System.out.println(entity);
			}
		}
		catch (ObjectNotFoundException onfe) {
			System.out.println("Id is not available");
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//close session object
			HibernateUtil.closeSession(session);
			//close SessionFactory object
			HibernateUtil.closeSessionFactory();
		}
	}
}