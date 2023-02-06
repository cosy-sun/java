package com.sun.design.adapterTest.classadapter;

import java.util.Date;
import java.util.List;

public class LinuxCustomer extends Customer implements News{

	@Override
	public void getNews() {
		System.out.println("获取新闻");
	}
	
	public LinuxCustomer(String qNumber, Date loginDate, List<?> friends) {
		super(qNumber, loginDate, friends);
	}
	
	public LinuxCustomer() {
		super();
	}
}
