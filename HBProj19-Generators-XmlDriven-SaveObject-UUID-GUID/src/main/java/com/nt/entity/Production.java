package com.nt.entity;

import java.io.Serializable;

public class Production implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String pid;
	private String pname;
	private Float price;
	private Integer qty;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	@Override
	public String toString() {
		return "Production [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + "]";
	}
}
