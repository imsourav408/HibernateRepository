package com.nt.proxy;

import com.nt.component.AmazonStore;
import com.nt.component.ECommerceStore;

public class ECommerceStoreDiscountProxy implements ECommerceStore {
	
	private double discount;
	private ECommerceStore real;
	
	public ECommerceStoreDiscountProxy(double discount) {
		this.discount=discount;
		real=new AmazonStore();
	}
	
	@Override
	public double shopping(double[] prices) {
		double realAmt;
		double finalAmt;
		
		realAmt=real.shopping(prices);
		finalAmt=realAmt-(realAmt*discount/100);
		return finalAmt;
	}
}