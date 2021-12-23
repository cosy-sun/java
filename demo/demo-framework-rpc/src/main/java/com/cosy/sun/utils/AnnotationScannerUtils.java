package com.cosy.sun.utils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AnnotationScannerUtils {
	
	public static List<Class<?>> doScan(List<Class<?>> includeFilter, String... basePackages) throws 
		IOException, ClassNotFoundException {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);
		log.info("扫描classpath*:{}的路径", Arrays.toString(basePackages));
		List<Class<?>> clazzSet = new ArrayList<>();
		for (String basePackage : basePackages) {
			String packageScanPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
					+ ClassUtils.convertResourcePathToClassName(basePackage) + "/**/*.class";
			Resource[] resources = resolver.getResources(packageScanPath);
			for (Resource resource : resources) {
				if (resource.isReadable()) {
					Class<?> matchClass = matchClass(metadataReaderFactory.getMetadataReader(resource), includeFilter);
					if(null != matchClass) {
						clazzSet.add(matchClass);
					}
				}
			}

		}
		return clazzSet;
	}

	public static Class<?> matchClass(MetadataReader metadataReader, List<Class<?>> includeFilter) {
		return handleFor(metadataReader, includeFilter);
		
	}
	
	public static Class<?> handleFor(MetadataReader metadataReader, List<Class<?>> list) {
		for(Class<?> item : list) {
			String className = metadataReader.getClassMetadata().getClassName();
			Class<?> forName = null;
			try {
				forName = Class.forName(className);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Class<?>[] interfaces = forName.getInterfaces();
			for(Class<?> clazz: interfaces) {
				if(clazz.getName().equals(Annotation.class.getName())) {
					return null;
				}
			}
			if(className.equals(item.getName())) {
				return forName;
			}
			@SuppressWarnings({ "unchecked", "rawtypes" })
			Annotation annotation = forName.getAnnotation((Class)item);
			if(annotation != null) {
				return forName;
			}
		}
		return null;
	}
}
