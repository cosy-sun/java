package com.cosy.sun.utils;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.springframework.stereotype.Component;

import com.cosy.sun.common.constant.ZkDefaultConstant;

@Component
public class CuratorUtils {

	public static CuratorFramework getClient(String zkAddr) {
		 CuratorFramework client = CuratorFrameworkFactory.builder()
				.connectString(zkAddr)
				.retryPolicy(new ExponentialBackoffRetry(0, 0, 0))
				.connectionTimeoutMs(ZkDefaultConstant.CONNECT_TIMEOUT)
				.sessionTimeoutMs(ZkDefaultConstant.SESSIN_TIMEOUT)
				.build();
		 client.start();
		 return client;
	}
	
	public static void create(CuratorFramework client, String path) throws Exception {
		client.create().creatingParentsIfNeeded().forPath(path);
	}
	
	public static void create(CuratorFramework client, String path, byte[] datas) throws Exception {
		client.create().creatingParentsIfNeeded().forPath(path, datas);
	}
	
	public static void createEphemeral(CuratorFramework client, String path) throws Exception {
		client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path);
	}
	
	public static void setData(CuratorFramework client, String path, byte[] datas) throws Exception {
		client.setData().forPath(path, datas);
	}

	public static void delete(CuratorFramework client, String path) throws Exception {
		client.delete().forPath(path);
	}
	
	public static void deleteChildren(CuratorFramework client, String path) throws Exception {
		client.delete().deletingChildrenIfNeeded().forPath(path);
	}
	
	public static void deleteGuaranteed(CuratorFramework client, String path) throws Exception {
		client.delete().guaranteed().forPath(path);
	}

	public static String getData(CuratorFramework client, String path) throws Exception {
		return new String(client.getData().forPath(path));
	}
	
	public static List<String> getChildren(CuratorFramework client, String path) throws Exception {
		return client.getChildren().forPath(path);
	}
	
	public static void watcher() throws Exception {
		
		
	}
	
}
