package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Production")
public class Production implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GenericGenerator(name = "gen1",strategy = "increment")
	//@GenericGenerator(name = "gen1",strategy = "identity") //change database to MySQL recommended
	//@GenericGenerator(name="gen1",strategy = "sequence")	//change database to Oracle recommended
	@GenericGenerator(name="gen1",strategy = "sequence",parameters = @Parameter(name="sequence_name",value = "STUDENT_SEQ"))
	@GeneratedValue(generator = "gen1")
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
