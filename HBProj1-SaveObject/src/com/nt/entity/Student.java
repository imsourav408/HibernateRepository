//Entity class/ Domain class/model class/Persistent class/POJO class/HLO(hibernate language object) class
package com.nt.entity;

import java.io.Serializable;
import java.sql.Date;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer sno;
	private String sname;
	private String sadd;
	private Date dob;
	private Float smark;
	private Float tmark;
	private Float cgpa;
	
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Float getSmark() {
		return smark;
	}
	public void setSmark(Float smark) {
		this.smark = smark;
	}
	public Float getTmark() {
		return tmark;
	}
	public void setTmark(Float tmark) {
		this.tmark = tmark;
	}
	public Float getCgpa() {
		return cgpa;
	}
	public void setCgpa(Float cgpa) {
		this.cgpa = cgpa;
	}
	
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + ", dob=" + dob + ", smark=" + smark
				+ ", tmark=" + tmark + ", cgpa=" + cgpa + "]";
	}

}
