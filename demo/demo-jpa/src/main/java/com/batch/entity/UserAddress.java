package com.batch.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "db_example")
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "eamli")
	private String eamli;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id", name = "address_id")
	private Address address;

	
	
	public UserAddress(String name, String eamli, Address address) {
		super();
		this.name = name;
		this.eamli = eamli;
		this.address = address;
	}

	public UserAddress(Long id, String name, String eamli, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.eamli = eamli;
		this.address = address;
	}

	public UserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEamli() {
		return eamli;
	}

	public void setEamli(String eamli) {
		this.eamli = eamli;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", name=" + name + ", eamli=" + eamli + ", address=" + address + "]";
	}
	
	
}
