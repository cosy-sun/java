package com.cosy.sun.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component
@NoArgsConstructor
@ConditionalOnProperty(havingValue = "true", name = "enable", prefix = "start.rpc")
public class ServerConfigProperties {

	@Value("${rpc.zk.addr}")
	private String zkAddr;
	
	@Value("${rpc.server.port}")
	private Integer port;
	
}
