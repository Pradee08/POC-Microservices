package com.centrica.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.centrica.model.Customer;
import com.centrica.service.CustomerService;

@RestController
public class CustomerServiceController {
	@Autowired
	private CustomerService service;

	@GetMapping("/customers/{ucrn}")
	public List<Customer> get(@PathVariable String ucrn) {
		return service.get(ucrn);
	}

	@PostMapping("/customers")
	public void add(@Valid @RequestBody Customer customer) {
		service.add(customer);
	}
	
	@PutMapping("/customers/{ucrn}")
	public ResponseEntity<?> update(@RequestBody Customer customer,@PathVariable String ucrn){
		try{
		
		//service.update(customer,ucrn);
		return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
