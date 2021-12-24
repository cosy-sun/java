package com.cosy.sun.config;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.stream.Stream;

import org.I0Itec.zkclient.exception.ZkException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.cosy.sun.anno.RpcClient;
import com.cosy.sun.aop.ProxyFactory;
import com.cosy.sun.server.operator.ServerOperator;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PostProcess implements BeanPostProcessor {
	
	@Autowired
	private ServerConfigProperties config;
	
	@Autowired
	private ServerOperator serverOperator;
	
	@Autowired
	private ProxyFactory proxyFactory;
	
	@Autowired
	private Environment env;
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		Class<?>[] interfaces = bean.getClass().getInterfaces();
		Stream.of(interfaces).forEach((clazz) -> {
			if (clazz.isAnnotationPresent(RpcClient.class)) {
				RpcClient annotation = clazz.getAnnotation(RpcClient.class);
				log.info("[{}] is annotated with  [{}]", bean.getClass().getName(), RpcClient.class.getCanonicalName());
				pushServer(bean.getClass(), 
						annotation.value().startsWith("${") ? env.resolvePlaceholders(annotation.value()) :annotation.value());
			}
		});
		Class<?> targetClass = bean.getClass();
        Field[] declaredFields = targetClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
        	Class<?> type = declaredField.getType();
        	if(type.isAnnotationPresent(RpcClient.class)) {
        		Object clientProxy = proxyFactory.getProxy(type);
        		declaredField.setAccessible(true);
        		try {
					declaredField.set(bean, clientProxy);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
        	}
        }
		return bean;
	}

	/**
	 * 注册服务到zk
	 * @param clazz
	 */
	private  void pushServer(Class<?> clazz, String serviceName) {
		try {
			String addr = InetAddress.getLocalHost().getHostAddress() + ":" + config.getPort();
			serverOperator.addServer(serviceName, addr, clazz, config.getZkAddr());
			log.info("注册zk成功, serviceName{}", serviceName);
		} catch (UnknownHostException e) {
			log.error("注册到zk异常", e);
			throw new ZkException("注册到zk异常");
		}
		
	}
	
}
