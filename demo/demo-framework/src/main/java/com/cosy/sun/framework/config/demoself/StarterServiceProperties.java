package com.cosy.sun.framework.config.demoself;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("com.sun")
public class StarterServiceProperties {

	private String config;
	
	public void setConfig(String config) {
		this.config = config;
	}
	
	public String getConfig() {
		return this.config;
	}
	
}
