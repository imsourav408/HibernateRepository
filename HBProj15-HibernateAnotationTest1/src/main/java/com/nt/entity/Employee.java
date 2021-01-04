package com.nt.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer eno;
	private String ename;
	private String eadd;
	private Date dob;
	
	@Id
	@Column(name = "ENO")
	public Integer getEno() {
		return eno;
	}
	
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	
	@Column(name = "ENAME")
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	@Column(name = "EADD")
	public String getEadd() {
		return eadd;
	}
	
	public void setEadd(String eadd) {
		this.eadd = eadd;
	}
	
	@Column(name = "DOB")
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
