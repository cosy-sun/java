package com.cosy.sun.mysql.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProp {
	private String url;
	private String userName;
	private String password;
	private String driverClassName;
}
