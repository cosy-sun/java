package com.cosy.sun.framework.config;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableHystrixDashboard
@EnableHystrix
public class HystrixDashboardConfig {

//	@Bean
//	public ServletRegistrationBean servletRegistration() {
//		HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
//		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean<>();
//		servletRegistrationBean.setServlet(hystrixMetricsStreamServlet);
//		servletRegistrationBean.addUrlMappings("/hystrix.stream");
//		servletRegistrationBean.setName("HystrixMetricsStreamServlet");
//		return servletRegistrationBean;
//	}

}
