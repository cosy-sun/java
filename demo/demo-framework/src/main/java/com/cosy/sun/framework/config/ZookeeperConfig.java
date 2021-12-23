package com.cosy.sun.framework.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@EnableDiscoveryClient
public class ZookeeperConfig {

	@LoadBalanced
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	@Bean
	public IRule loadBalancedRule() {
		return new RandomRule();
	}
	
}
