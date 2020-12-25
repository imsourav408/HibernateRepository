package com.nt.test;

import com.nt.component.ECommerceStore;
import com.nt.factory.EcommerceStoreFactory;

public class Customer1 {

	public static void main(String[] args) {
		ECommerceStore store=null;
		store=EcommerceStoreFactory.getInstance("   ");
		System.out.println(store.getClass());
		System.out.println("Your total bill amount for shopping of items are: "+store.shopping(new double[] {1000,2000,3000}));
	}
}