package com.nt.component;

public class AmazonStore implements ECommerceStore {

	@Override
	public double shopping(double[] prices) {
		double totalAmt=0.0f;
		for(double price:prices)
			totalAmt+=price;
		return totalAmt;
	}
/*	
	@Override
	public String shopping(double[] prices) {
		double totalAmt=0.0f;
		totalAmt=DoubleStream.of(prices).sum();
		return return totalAmt;
	}*/
}