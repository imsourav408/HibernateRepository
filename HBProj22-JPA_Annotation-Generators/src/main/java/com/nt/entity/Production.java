package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Production")
public class Production implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)	//only useful in MySQL
	
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)		//Recommended to use only in oracle
	
	/*@SequenceGenerator(name = "gen1",sequenceName = "PID_SEQ",initialValue = 10,allocationSize = 5)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)*/
	
	/*@SequenceGenerator(name = "gen1",sequenceName = "PID_SEQ")
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)*/
	
	/*@SequenceGenerator(name = "gen1",sequenceName = "CORONA_SEQ",allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)*/
	
	/*@TableGenerator(name = "gen1",pkColumnName = "ID_COL",pkColumnValue = "PID",table = "ID_TAB",initialValue = 10,allocationSize = 3)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.TABLE)*/
	
	//@GeneratedValue(generator = "gen1",strategy = GenerationType.TABLE)
	
	//@GeneratedValue(generator = "gen1",strategy = GenerationType.AUTO)
	
	@SequenceGenerator(name = "gen1",sequenceName = "PID_SEQ",initialValue = 2,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.AUTO)
	private Integer pid;
	@Type(type = "string")
	@Column(name = "PNAME",length = 25)
	private String pname;
	@Type(type = "float")
	@Column(name = "PRICE")
	private Float price;
	@Type(type = "int")
	@Column(name = "QTY")
	private Integer qty;
	
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
