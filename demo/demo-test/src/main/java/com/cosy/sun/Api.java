package com.cosy.sun;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("api")
public interface Api {

	@RequestMapping("/api")
	public String api();

}
