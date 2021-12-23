package com.cosy.sun.server.loadbalance.adaptor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cosy.sun.server.loadbalance.AbsLoadBalance;

/**
 * 加权轮询法
 */
@Component
public class WeightPollAdaptor extends AbsLoadBalance {

	private static Integer pos = 0;
	
	@Override
	protected String selectServer(List<String> serverList, String serverName) {
		List<String> tmp = new ArrayList<>();
		//此处不做权重的兼容. 默认权重都是5
		serverList.forEach(item -> {
			for(int i = 0; i < 5; i ++) {
				tmp.add(item);
			}
		});
		
		synchronized (pos) {
			if(pos > tmp.size()) {
				pos = 0;
			}
			return tmp.get(pos ++);
		}
	}

}
