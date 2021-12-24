package com.cosy.sun.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(havingValue = "true", name = "enable", prefix = "start.rpc")
@ComponentScan("com.cosy.sun")
public class RpcAutoConfig {

}
