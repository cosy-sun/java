package com.batch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "examples", schema = "db_example")
@IdClass(value = ExamplesKey.class)
public class Example {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "name", nullable = true)
	private String mingzi;
	@Id
	@Column(name = "phone", nullable = true)
	private String dianhua;
//	
//	public void setName(String name) {
//		
//		this.name = name;
//		
//	}
//	
//	public String getName() {
//		return this.name;
//	}
//	
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	
//	public String getPhone() {
//		return this.phone;
//	}
	public String getMingzi() {
		return mingzi;
	}
	public void setMingzi(String mingzi) {
		this.mingzi = mingzi;
	}
	public String getDianhua() {
		return dianhua;
	}
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	
}
