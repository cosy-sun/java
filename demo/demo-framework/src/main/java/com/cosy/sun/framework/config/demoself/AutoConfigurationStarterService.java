package com.cosy.sun.framework.config.demoself;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(value = StarterService.class)
@EnableConfigurationProperties(StarterServiceProperties.class)
public class AutoConfigurationStarterService {

	@Autowired
	private StarterServiceProperties properties;
	
	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnProperty(prefix = "com.sun", value = "enabled", havingValue = "true")
	StarterService starterService() {
		return new StarterService(properties.getConfig());
	}

}
