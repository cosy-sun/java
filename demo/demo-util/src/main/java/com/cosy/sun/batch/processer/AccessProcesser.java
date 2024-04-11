package com.cosy.sun.batch.processer;

import org.springframework.batch.item.ItemProcessor;

import com.cosy.sun.batch.bean.Access;

public class AccessProcesser implements ItemProcessor<Access, Access>{

	@Override
	public Access process(Access item) throws Exception {
		System.out.println(item.toString());
		return null;
	}

}
