package com.cosy.sun.server.register.adaptor;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.I0Itec.zkclient.exception.ZkException;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cosy.sun.common.constant.ZkDefaultConstant;
import com.cosy.sun.common.exception.RpcException;
import com.cosy.sun.config.ServerConfigProperties;
import com.cosy.sun.server.loadbalance.LoadBalance;
import com.cosy.sun.server.register.ServerDiscovery;
import com.cosy.sun.utils.CuratorUtils;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Component
@Setter
@Scope("singleton")
@Slf4j
public class CuatorServerDiscoveryAdaptor implements ServerDiscovery {

	@Resource(name = "${rpc.policy.loadbalance}")
	private LoadBalance loadBalance;
	
	@Autowired
	private ServerConfigProperties config;
	
	private Map<String, List<String>> serverMap = new ConcurrentHashMap<>();
	
	@Override
	public InetSocketAddress getService(String serviceName) {
		List<String> children;
		if(serverMap.containsKey(serviceName)) {
			children = serverMap.get(serviceName);
		} else {
			CuratorFramework client = CuratorUtils.getClient(config.getZkAddr());
			try {
				children = CuratorUtils.getChildren(client, ZkDefaultConstant.ZK_BASE_PATH + "/" + serviceName);
				serverMap.put(serviceName, children);
				register(client, serviceName);
			} catch (Exception e) {
				throw new RpcException("获取服务异常", e);
			}
		}
		String selectService = loadBalance.selectService(children, serviceName);
		String[] split = selectService.split(":");
		return new InetSocketAddress(split[0],Integer.valueOf(split[1]));
	}
	
	private void register(CuratorFramework client, String serviceName) {
		PathChildrenCache pathChildrenCache = new PathChildrenCache(client, ZkDefaultConstant.ZK_BASE_PATH + "/" + serviceName, true);
		pathChildrenCache.getListenable().addListener((CuratorFramework zkClient, PathChildrenCacheEvent event) -> {
			log.info("监听服务执行: serviceName{}", serviceName);
//				Type type = event.getType();
				// 根据事件类型可以做不同的处理
				List<String> children = CuratorUtils.getChildren(zkClient, ZkDefaultConstant.ZK_BASE_PATH + "/" + serviceName);
				if(children == null || children.size() == 0) {
					serverMap.remove(serviceName);
					return ;
				}
				serverMap.put(serviceName, children);
		});
		try {
			pathChildrenCache.start();
		} catch (Exception e) {
			throw new ZkException(e);
		}
	}

}
