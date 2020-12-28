package com.nt.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		Configuration configuration=null;
		try {
			//Bootstrap hibernate f/w
			configuration=new Configuration();
			//input configuration file location
			configuration.configure("com/nt/cfgs/hibernate.cfg.xml");
			//create factory object
			factory=configuration.buildSessionFactory();
		}
		catch (HibernateException hbe) {
			hbe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//use full only with try with resources
	public static SessionFactory getSessionFactory() {
		if(factory!=null)
			return factory;
		else
			throw new HibernateException("Problem in creating session factory object");
	}
/*	
	public static Session getSession() {
		Session session=null;
		if(factory!=null)
			session=factory.openSession();
		return session;
	}
	
	public static void closeSession(Session session) {
		if(session!=null)
			session.close();
	}
	
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
*/
}
