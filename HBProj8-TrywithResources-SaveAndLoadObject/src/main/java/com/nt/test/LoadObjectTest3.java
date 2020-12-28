package com.nt.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Entity;
import com.nt.entity.Patient;
import com.nt.util.HibernateUtil;

public class LoadObjectTest3 {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		//try with java 9 syntax
		try(factory;session){
			Entity entity=session.load(Patient.class, 10001);
			System.out.println(entity.getClass()+"  "+entity.getClass().getSuperclass()+"  "+Arrays.toString(entity.getClass().getInterfaces()));
			System.out.println(entity);
		}
		catch (ObjectNotFoundException onfe) {
			System.out.println("Incorrect id value");
		}
		catch (HibernateException he) {
			he.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
