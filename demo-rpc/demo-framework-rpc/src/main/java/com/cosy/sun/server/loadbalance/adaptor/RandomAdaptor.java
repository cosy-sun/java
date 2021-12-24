package com.cosy.sun.server.loadbalance.adaptor;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.cosy.sun.server.loadbalance.AbsLoadBalance;

import lombok.extern.slf4j.Slf4j;

/**
 * 随机负载均衡
 */
@Component
@Slf4j
public class RandomAdaptor extends AbsLoadBalance {

	@Override
	protected String selectServer(List<String> serverList, String serverName) {
		return serverList.get(new Random().nextInt(serverList.size()));
	}

}
