package com.centrica.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.centrica.model.Customer;
import com.centrica.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerServiceController {
	@Autowired
	private CustomerService service;

	@GetMapping("/{id}")
	public ResponseEntity<Customer> retrieve(@PathVariable int id) {
		try {
			Customer customer = service.retrivecustomer(id);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public ResponseEntity<List<Customer>> retrieve(@RequestParam String ucrn) {
		try {
			List<Customer> customer = service.retrieve(ucrn);
			if (!customer.isEmpty())
				return new ResponseEntity<List<Customer>>(customer, HttpStatus.OK);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> add(@Valid @RequestBody Customer customer) {
		service.add(customer);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable int id) {
		try {
			Customer existCustomer = service.retrivecustomer(id);
			service.update(customer, id, existCustomer);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
