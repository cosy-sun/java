package com.cosy.sun.config;

import javax.annotation.PreDestroy;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosy.sun.common.constant.ZkDefaultConstant;
import com.cosy.sun.utils.CuratorUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EndOperator {
	
	@Autowired
	private ServerConfigProperties config;
	
	@PreDestroy
	public void applicationDesctroy() throws Exception {
		log.info("撤销注册的内容");
		String zkBasePath = ZkDefaultConstant.ZK_BASE_PATH;
		CuratorFramework client = CuratorUtils.getClient(config.getZkAddr());
		CuratorUtils.deleteChildren(client, zkBasePath);
	}
	
}
