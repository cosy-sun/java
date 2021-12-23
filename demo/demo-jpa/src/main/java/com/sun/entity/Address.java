package com.sun.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address", schema = "db_example")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String street;
	
	@OneToOne(mappedBy = "address")
	private UserAddress user;

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Address(long id, String street) {
		super();
		this.id = id;
		this.street = street;
	}

	public Address() {
		super();
	}

}
