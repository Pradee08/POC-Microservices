package com.centrica.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.centrica.feignservice.FeignService;
import com.centrica.model.Account;
import com.centrica.model.Customer;
import com.centrica.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountServiceController {

	@Autowired
	private FeignService feignService;
	@Autowired
	private AccountService service;

	@PostMapping
	public ResponseEntity<?> add(@Valid @RequestBody Account account) {
		try {
			Customer customer = feignService.getData(account.getCustomerId());
			List<String> energyaccount = customer.getEnergyAccounts();
			for (String accountid : energyaccount) {
				String id = account.getId();
				if (id.equalsIgnoreCase(accountid)) {
					service.add(account);
				}
			}
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> retrieve(@PathVariable String id) {
		try {
			Account accountdetails = service.retrieve(id);
			return new ResponseEntity<>(accountdetails, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Account account, @PathVariable String id) {
		try {
			Account existAccount = service.retrieve(id);
			service.update(account, id, existAccount);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) throws Exception {
		try {
			Account account = service.retrieve(id);
			if(account.getStatus().equalsIgnoreCase("open")){
				throw new Exception("Should not delete account if the account status is open");
			}
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
}
