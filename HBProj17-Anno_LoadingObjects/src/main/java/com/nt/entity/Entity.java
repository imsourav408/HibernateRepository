package com.nt.entity;

import java.sql.Date;

public interface Entity {
	public Integer getEno();
	public void setEno(Integer eno);
	public String getEname();
	public void setEname(String ename);
	public String getEadd();
	public void setEadd(String eadd);
	public Date getDob();
	public void setDob(Date dob);
}