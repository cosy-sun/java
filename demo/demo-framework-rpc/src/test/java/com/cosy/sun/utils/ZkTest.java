package com.cosy.sun.utils;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;

import org.I0Itec.zkclient.ZkClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.junit.Test;

public class ZkTest {

	// --------------------------- curatorframework start
	@Test
	public void create() throws Exception {
		CuratorFramework client = CuratorUtils.getClient("192.168.56.10:2181");
		String localHost = InetAddress.getLocalHost().getHostAddress();
		CuratorUtils.create(client, "/sunzhenhua/szh/cosy" + "/hello" + new InetSocketAddress(localHost, 100).toString());
	}
	
	@Test
	public void get() throws Exception {
		CuratorFramework client = CuratorUtils.getClient("192.168.56.10:2181");
		List<String> children = CuratorUtils.getChildren(client, "/sunzhenhua/szh/cosy" + "/hello");
		System.out.println(Arrays.toString(children.toArray()));
	}
	
	@Test
	public void delete() throws Exception {
		CuratorFramework client = CuratorUtils.getClient("192.168.56.10:2181");
		CuratorUtils.deleteChildren(client, "/sunzhenhua");
	}
	// -------------------------- curatorframework end 
	
	// -------------------------- zkClient start
	@Test
	public void zkClientCreate() throws Exception {
		ZkClient client = ZkClientUtils.getClient();
		ZkClientUtils.create(client, "/sunzhenhua", CreateMode.PERSISTENT);
	}
	// -------------------------- zkClient end
	
}
