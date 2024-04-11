package com.cosy.sun.framework.config.demoself;

import org.springframework.util.StringUtils;

public class StarterService {

	private String config;
	
	public StarterService(String config) {
		this.config = config;
	}
	
	public String[] splits(String delimiter) {
		return StringUtils.split(this.config, delimiter);
	}
	
}
