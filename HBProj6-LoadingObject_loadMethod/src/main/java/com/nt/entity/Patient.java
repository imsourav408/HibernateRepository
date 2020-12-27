package com.nt.entity;

import java.io.Serializable;

public class Patient implements Serializable{
	private static final long serialVersionUID=1l;
	
	private Integer pid;
	private String pname;
	private String padd;
	private Integer page;
	private String psex;
	private String pstage;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPadd() {
		return padd;
	}
	public void setPadd(String padd) {
		this.padd = padd;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getPsex() {
		return psex;
	}
	public void setPsex(String psex) {
		this.psex = psex;
	}
	public String getPstage() {
		return pstage;
	}
	public void setPstage(String pstage) {
		this.pstage = pstage;
	}
	
	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", padd=" + padd + ", page=" + page + ", psex=" + psex
				+ ", pstage=" + pstage + "]";
	}
}
