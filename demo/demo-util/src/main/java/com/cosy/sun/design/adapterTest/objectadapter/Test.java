package com.cosy.sun.design.adapterTest.objectadapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		LoginEvent loginEvent = new LinuxLoginEvent("sunzhenhua", new Date(), list);
		loginEvent.getNews();
		System.out.println(Arrays.toString(loginEvent.getFriends().toArray()));
		
	}
	
}
