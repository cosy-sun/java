package com.cosy.sun.server.loadbalance.adaptor;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cosy.sun.server.loadbalance.LoadBalance;

/**
 * 最小连接数法
 */
@Component
public class MinConnNumAdaptor implements LoadBalance {

	@Override
	public String selectService(List<String> serviceList, String serviceName) {
		return null;
	}

}
