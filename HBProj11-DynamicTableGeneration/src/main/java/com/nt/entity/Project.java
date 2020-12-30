package com.nt.entity;

import java.io.Serializable;

public class Project implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long projId;
	private String projName;
	private Integer teamSize;
	
	public Long getProjId() {
		return projId;
	}
	public void setProjId(Long projId) {
		this.projId = projId;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public Integer getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}
	
	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", teamSize=" + teamSize + "]";
	}	
}
