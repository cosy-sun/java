package com.cosy.sun.server.loadbalance.adaptor;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cosy.sun.server.loadbalance.AbsLoadBalance;

/**
 * 轮询法
 */
@Component
public class PollAdaptor extends AbsLoadBalance {

	private static Integer pos = 0;
	
	@Override
	protected String selectServer(List<String> serviceList, String serverName) {
		synchronized (pos) {
			if(pos > serviceList.size()) {
				pos = 0;
			}
			return serviceList.get(pos++);
		}
	}

}
