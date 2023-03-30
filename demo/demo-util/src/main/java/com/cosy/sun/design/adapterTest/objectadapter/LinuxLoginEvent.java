package com.cosy.sun.design.adapterTest.objectadapter;

import java.util.Date;
import java.util.List;

public class LinuxLoginEvent extends LoginEvent{

	public LinuxLoginEvent(String qNumber, Date loginDate, List<?> friends) {
		super(qNumber, loginDate, friends);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getNews() {
		System.out.println("获取新闻");
	}

}
