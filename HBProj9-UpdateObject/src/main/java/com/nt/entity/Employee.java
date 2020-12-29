package com.nt.entity;

import java.io.Serializable;
import java.sql.Date;

public class Employee implements Serializable{
	private static final long serialVersionUID=1l;
	
	private Integer eno;
	private String ename;
	private String eadd;
	private Date dob;
	
	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEadd() {
		return eadd;
	}
	public void setEadd(String eadd) {
		this.eadd = eadd;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", eadd=" + eadd + ", dob=" + dob + "]";
	}
}
