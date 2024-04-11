//package com.cosy.sun.hadoop.config;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//
//@org.springframework.context.annotation.Configuration
//public class HadoopConfig {
//
//	@Value("${hdfs.url}")
//	private String path;
//
//	@Value("${hdfs.username}")
//	private String username;
//
//	@Bean
//	public Configuration configuration() {
//		Configuration configuration = new Configuration();
//		configuration.set("fs.defaultFs", path);
//		return configuration;
//	}
//
//	@Bean
//	public FileSystem getFileSystem() throws IOException, InterruptedException, URISyntaxException {
//		return FileSystem.get(new URI(path), configuration(), username);
//	}
//
//}
