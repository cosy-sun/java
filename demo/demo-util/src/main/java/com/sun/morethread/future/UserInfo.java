package com.sun.morethread.future;

public class UserInfo {

	private String username;
	private String userpassword;
	
	public UserInfo() {
	}
	
	public UserInfo(String username, String userpassword) {
		this.username = username;
		this.userpassword = userpassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", userpassword=" + userpassword + "]";
	}
	
}
class Runnable01 implements  Runnable {
	
	private UserInfo userinfo;
	
	public Runnable01(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	
	public void run() {
		userinfo.setUsername("usernamevalue");
		userinfo.setUserpassword("userpasswordvalue");
	}
}
