package com.cosy.sun.jdk.design.adapterTest.classadapter;

import java.util.Date;
import java.util.List;

public class Customer {

	private String qNumber;
	private Date loginDate;
	private List<?> friends;
	public String getqNumber() {
		return qNumber;
	}
	public void setqNumber(String qNumber) {
		this.qNumber = qNumber;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public List<?> getFriends() {
		return friends;
	}
	public void setFriends(List<?> friends) {
		this.friends = friends;
	}
	public Customer(String qNumber, Date loginDate, List<?> friends) {
		super();
		this.qNumber = qNumber;
		this.loginDate = loginDate;
		this.friends = friends;
	}
	public Customer() {
		super();
	}
}
