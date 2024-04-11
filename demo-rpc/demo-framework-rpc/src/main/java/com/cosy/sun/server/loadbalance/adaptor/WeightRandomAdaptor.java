package com.cosy.sun.server.loadbalance.adaptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.cosy.sun.server.loadbalance.AbsLoadBalance;

/**
 * 加权随机
 */
@Component
public class WeightRandomAdaptor extends AbsLoadBalance {

	@Override
	protected String selectServer(List<String> serverList, String serverName) {
		List<String> tmp = new ArrayList<>();
		//此处不做权重的兼容. 默认权重都是5
		serverList.forEach(item -> {
			for(int i = 0; i < 5; i ++) {
				tmp.add(item);
			}
		});
		return tmp.get(new Random().nextInt(tmp.size()));
	}

}
