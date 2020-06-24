package com.centrica.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.centrica.model.Account;

@FeignClient(name = "Account-Service", url = "http://localhost:8081")
public interface FeignService {
	@RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}")
	public Account getData(@PathVariable("id") String id);
}
