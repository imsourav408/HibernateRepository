package com.nt.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		Configuration configuration=null;
		try {
			//Bootstrap hibernate framework
			configuration=new Configuration();
			//Give configuration file location
			configuration.configure("com/nt/cfgs/hibernate.cfg.xml");
			//create SessionFactory object
			factory=configuration.buildSessionFactory();
		}
		catch (HibernateException hbe) {
			hbe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
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
}