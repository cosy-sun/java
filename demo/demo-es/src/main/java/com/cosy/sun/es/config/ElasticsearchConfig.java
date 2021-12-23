package com.cosy.sun.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

	@Bean
	public RestHighLevelClient restHighLevelClient() {
		RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.56.10", 9200, "http")));
		return client;
	}
	
}
