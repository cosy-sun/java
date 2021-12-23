package com.sun.processer;

import org.springframework.batch.item.ItemProcessor;

import com.sun.bean.Access;

public class AccessProcesser implements ItemProcessor<Access, Access>{

	@Override
	public Access process(Access item) throws Exception {
		System.out.println(item.toString());
		return null;
	}

}
