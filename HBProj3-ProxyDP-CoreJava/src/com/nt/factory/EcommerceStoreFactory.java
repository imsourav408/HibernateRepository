package com.nt.factory;

import com.nt.component.AmazonStore;
import com.nt.component.ECommerceStore;
import com.nt.proxy.ECommerceStoreDiscountProxy;

public class EcommerceStoreFactory {
	
	public static ECommerceStore getInstance(String cuponCode) {
		if(cuponCode.equals("") || cuponCode.trim().length()==0)
			return new AmazonStore();
		else if(cuponCode.equalsIgnoreCase("AM10"))
			return new ECommerceStoreDiscountProxy(10);
		else if(cuponCode.equalsIgnoreCase("AM20"))
			return new ECommerceStoreDiscountProxy(20);
		else if(cuponCode.equalsIgnoreCase("AM5"))
			return new ECommerceStoreDiscountProxy(5);
		else
			throw new IllegalArgumentException("Invalid Cupon Code");
	}
}