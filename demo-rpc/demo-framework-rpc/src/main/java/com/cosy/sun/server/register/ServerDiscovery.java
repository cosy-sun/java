package com.cosy.sun.server.register;

import java.net.InetSocketAddress;

public interface ServerDiscovery {

	public InetSocketAddress getService(String serviceName);
	
}
