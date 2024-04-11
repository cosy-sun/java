//package com.cosy.sun.config;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.beans.factory.support.AbstractBeanDefinition;
//import org.springframework.beans.factory.support.BeanDefinitionBuilder;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
//import org.springframework.beans.factory.support.GenericBeanDefinition;
//import org.springframework.stereotype.Component;
//
//import com.cosy.sun.anno.RpcClient;
//import com.cosy.sun.aop.RpcFactoryBean;
//import com.cosy.sun.common.exception.RpcException;
//import com.cosy.sun.utils.AnnotationScannerUtils;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Component
//@Slf4j
//public class BendefinationRegis implements BeanDefinitionRegistryPostProcessor {
//	
//	@Override
//	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		
//	}
//
//	@Override
//	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//		List<Class<?>> doScan = null;
//		try {
//			doScan = AnnotationScannerUtils.doScan(Arrays.asList(RpcClient.class), "com");
//		} catch (ClassNotFoundException | IOException e) {
//			log.error("扫描注解异常", e);
//			throw new RpcException();
//		}
//		doScan.forEach(clazz -> {
//			BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
//			AbstractBeanDefinition definition = builder.getRawBeanDefinition();
//			definition.getPropertyValues()
//				.add("clazz", clazz);
//			definition.setBeanClass(RpcFactoryBean.class);
//			definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
//			registry.registerBeanDefinition(clazz.getSimpleName(), definition);
//			
//		});
//	}
//
//}
