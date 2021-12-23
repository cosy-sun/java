package com.cosy.sun.server.loadbalance;

import java.util.List;

public abstract class AbsLoadBalance implements LoadBalance {

	@Override
	public String selectService(List<String> serverList, String serverName) {
		if(serverList == null || serverList.size() == 0) {
			return null;
		}
		if(serverList.size() == 1) {
			return serverList.get(0);
		}
		return selectServer(serverList, serverName);
	}
	
	protected abstract String selectServer(List<String> serverList, String serverName);
}
