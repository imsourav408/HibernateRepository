package com.nt.entity;

import java.io.Serializable;
import java.sql.Date;

public class Production implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer pid;
	private String pname;
	private Date pdate;
	
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
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	
	@Override
	public String toString() {
		return "Production [pid=" + pid + ", pname=" + pname + ", pdate=" + pdate + "]";
	}	
}
