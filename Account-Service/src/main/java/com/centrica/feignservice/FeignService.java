package com.centrica.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.centrica.model.Customer;

@FeignClient(name = "Customer-Service", url = "http://localhost:8080")
public interface FeignService {
	@RequestMapping(method = RequestMethod.GET, value = "/customers/{id}")
	public Customer getData(@PathVariable("id") int id);
}