package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		Configuration configuration=null;
		try {
			//bootstrap hibernate framework
			configuration=new Configuration();
			//give configuration file details
			configuration.configure("com/nt/cfgs/hibernate.cfg.xml");
			//build factory object
			factory=configuration.buildSessionFactory();
		}
		catch (HibernateException he) {
			he.printStackTrace();
		}
		catch (Exception e) {
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
	
	public static void closeSessionFcatory() {
		if(factory!=null)
			factory.close();
	}
}
