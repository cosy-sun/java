package com.cosy.sun.server.loadbalance;

import java.util.List;

public interface LoadBalance {

	 String selectService(List<String> serviceList, String serviceName);
	
}
