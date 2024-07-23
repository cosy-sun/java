package com.cosy.sun.algorithm.design.adapterTest.objectadapter;

import java.util.Date;
import java.util.List;

public abstract class LoginEvent {

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
	
	public LoginEvent(String qNumber, Date loginDate, List<?> friends) {
		super();
		this.qNumber = qNumber;
		this.loginDate = loginDate;
		this.friends = friends;
	}
	public abstract void getNews();
	
}
