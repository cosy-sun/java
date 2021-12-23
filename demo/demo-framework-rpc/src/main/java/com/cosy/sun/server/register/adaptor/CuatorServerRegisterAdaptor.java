package com.cosy.sun.server.register.adaptor;

import org.I0Itec.zkclient.exception.ZkException;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cosy.sun.common.constant.ZkDefaultConstant;
import com.cosy.sun.server.register.ServerRegister;
import com.cosy.sun.utils.CuratorUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Scope("singleton")
@Slf4j
public class CuatorServerRegisterAdaptor implements ServerRegister {

	@Override
	public void register(String serviceName, String addr, String zkAddr) {
		CuratorFramework client = CuratorUtils.getClient(zkAddr);
		String path = ZkDefaultConstant.ZK_BASE_PATH + "/" + serviceName + "/" + addr;
		try {
			if(client.checkExists().forPath(path) == null) {
				CuratorUtils.createEphemeral(client, path);
			}
		} catch (Exception e) {
			log.error("注册到zk失败", e);
			throw new ZkException("zk register exception", e);
		}
	}
}
