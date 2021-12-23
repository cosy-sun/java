package com.cosy.sun.utils;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

import com.cosy.sun.common.constant.ZkDefaultConstant;

public class ZkClientUtils {

	public static ZkClient getClient() {
		return new ZkClient(ZkDefaultConstant.DEFAULT_ZK_ADDR, ZkDefaultConstant.CONNECT_TIMEOUT);
	}

	public static void close(ZkClient client) {
		if(client != null)
			client.close();
	}
	
	static void create(ZkClient client, String path, CreateMode mode) {
		client.create(path, null, mode);
	}
	
	public static void delete(ZkClient client, String path) {
		client.deleteRecursive(path);
	}
	
	public static void setData(ZkClient client, String path, Object datas) {
		client.writeData(path, datas);
	}
	
	public static <T> T getData(ZkClient client, String path, Class<T> cl) {
		return cl.cast(client.readData(path));
	}
	
}
