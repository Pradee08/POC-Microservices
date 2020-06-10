package com.centrica.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.centrica.model.Customer;
import com.centrica.service.CustomerService;

@RestController
public class CustomerServiceController {
	@Autowired
	private CustomerService service;

	@GetMapping("/customers/{ucrn}")
	public Customer get(@PathVariable String ucrn) {
		return service.get(ucrn);
	}

	@PostMapping("/customers")
	public void add(@Valid @RequestBody Customer customer) {
		service.add(customer);
	}
}
