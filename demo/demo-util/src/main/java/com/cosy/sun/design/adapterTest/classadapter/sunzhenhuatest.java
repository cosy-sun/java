package com.cosy.sun.design.adapterTest.classadapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class sunzhenhuatest {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		LinuxCustomer lc = new LinuxCustomer("sunzhenhua", new Date(), list);
		System.out.println(lc.getqNumber());
		System.out.println(lc.getLoginDate());
		System.out.println(Arrays.toString(lc.getFriends().toArray()));
	}
	
}
