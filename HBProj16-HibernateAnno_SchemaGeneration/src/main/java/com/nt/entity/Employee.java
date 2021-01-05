package com.nt.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "EMPLOYEE_TABLE")
@DynamicInsert(value = true)
@DynamicUpdate(false)
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id()
	@Column(name = "Eno",length = 20)
	@Type(type = "int")
	private Integer eno;
	
	@Column(name = "Name",length = 20)
	@Type(type = "string")
	private String ename;
	
	@Column(name = "Address",length = 20)
	@Type(type = "string")
	private String eadd;
	
	@Column(name = "Dob")
	@Type(type = "date")
	private Date dob;
	
	@Column(name = "Job",length = 20)
	@Type(type = "string")
	private String job;
	
	@Column(name = "Salary",length = 20)
	@Type(type = "int")
	@Transient
	private Double sal;
	
	/*
	 * @Id()
	 * 
	 * @Column(name = "Eno",length = 20)
	 * 
	 * @Type(type = "int")
	 */
	public Integer getEno() {
		return eno;
	}
	
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	
	/*
	 * @Column(name = "Name",length = 20)
	 * 
	 * @Type(type = "string")
	 */
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	/*
	 * @Column(name = "Address",length = 20)
	 * 
	 * @Type(type = "string")
	 */
	public String getEadd() {
		return eadd;
	}
	
	public void setEadd(String eadd) {
		this.eadd = eadd;
	}
	
	/*
	 * @Column(name = "Dob")
	 * 
	 * @Type(type = "date")
	 */
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	/*
	 * @Column(name = "Job",length = 20)
	 * 
	 * @Type(type = "string")
	 */
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	/*
	 * @Column(name = "Salary",length = 20)
	 * 
	 * @Type(type = "int")
	 * 
	 * @Transient
	 */
	public Double getSal() {
		return sal;
	}
	
	public void setSal(Double sal) {
		this.sal = sal;
	}
	
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", eadd=" + eadd + ", dob=" + dob + ", job=" + job
				+ ", sal=" + sal + "]";
	}
}
