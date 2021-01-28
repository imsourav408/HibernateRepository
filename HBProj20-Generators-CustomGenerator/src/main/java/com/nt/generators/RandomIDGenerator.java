package com.nt.generators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomIDGenerator implements IdentifierGenerator{

	public RandomIDGenerator() {
		System.out.println("RandomIDGenerator.RandomIDGenerator()");
	}
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		System.out.println("RandomIDGenerator.generate()");
		String idVal=null;
		//generate idVal
		idVal="NIT"+new Random().nextInt(10000);
		return idVal;
	}

}
