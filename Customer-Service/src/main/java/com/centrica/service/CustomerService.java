package com.centrica.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.centrica.model.Customer;
import com.centrica.model.Customers;
import com.centrica.model.PhoneNumber;
import com.centrica.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	public void add(Customer customer) {
		Customers customers = new Customers();
		ModelMapper mapper = new ModelMapper();
		List<String> number = customer.getTelephoneNumbers().stream().map(p -> p.getNumber())
				.collect(Collectors.toList());
		List<String> type = customer.getTelephoneNumbers().stream().map(p -> p.getType()).collect(Collectors.toList());
		customers = mapper.map(customer, Customers.class);
		customers.setEnergyAccounts(customer.getEnergyAccounts().toString().replace("[", "").replace("]", ""));
		customers.setNumber(String.join(",", number));
		customers.setType(String.join(",", type));
		repo.save(customers);
		return;
	}

	public List<Customer> retrieve(String ucrn) {
		Customer customer = new Customer();
		List<Customer> listofcustomer = new ArrayList<Customer>();
		List<Customers> customerList = repo.findByUcrn(ucrn);
		ModelMapper mapper = new ModelMapper();
		for (Customers customers : customerList) {
			ArrayList<PhoneNumber> phonedetails = new ArrayList<PhoneNumber>();
			customer = mapper.map(customers, Customer.class);
			List<String> energyaccount = Stream.of(customers.getEnergyAccounts().split(","))
					.collect(Collectors.toList());
			customer.setEnergyAccounts(energyaccount);
			List<String> telephonenumber = Stream.of(customers.getNumber().split(",")).collect(Collectors.toList());
			List<String> type = Stream.of(customers.getType().split(",")).collect(Collectors.toList());
			String[] tempnumber = telephonenumber.toArray(new String[0]);
			String[] temptype = type.toArray(new String[0]);
			int length = telephonenumber.size();
			for (int i = 0; i <= length - 1; i++) {
				PhoneNumber phonenumber = new PhoneNumber();
				phonenumber.setNumber(tempnumber[i]);
				phonenumber.setType(temptype[i]);
				phonedetails.add(phonenumber);
			}
			customer.setTelephoneNumbers(phonedetails);
			listofcustomer.add(customer);
		}
		return listofcustomer;
	}

	public Customer retrivecustomer(int id) {
		Customer customer = new Customer();
		Customers customerList = repo.findById(id);
		ModelMapper mapper = new ModelMapper();
		ArrayList<PhoneNumber> phonedetails = new ArrayList<PhoneNumber>();
		customer = mapper.map(customerList, Customer.class);
		List<String> energyaccount = Stream.of(customerList.getEnergyAccounts().split(","))
				.collect(Collectors.toList());
		customer.setEnergyAccounts(energyaccount);
		List<String> telephonenumber = Stream.of(customerList.getNumber().split(",")).collect(Collectors.toList());
		List<String> type = Stream.of(customerList.getType().split(",")).collect(Collectors.toList());
		String[] tempnumber = telephonenumber.toArray(new String[0]);
		String[] temptype = type.toArray(new String[0]);
		int length = telephonenumber.size();
		for (int i = 0; i <= length - 1; i++) {
			PhoneNumber phonenumber = new PhoneNumber();
			phonenumber.setNumber(tempnumber[i]);
			phonenumber.setType(temptype[i]);
			phonedetails.add(phonenumber);
		}
		customer.setTelephoneNumbers(phonedetails);
		return customer;
	}

	public void update(Customer customer, int id, Customer existCustomer) {
		ModelMapper mapper = new ModelMapper();
		if (existCustomer.getId().equals(id)) {
			existCustomer.setFirstName(customer.getFirstName());
			existCustomer = mapper.map(customer, Customer.class);
			Customers customers = new Customers();
			ModelMapper mapper1 = new ModelMapper();
			List<String> number = existCustomer.getTelephoneNumbers().stream().map(p -> p.getNumber())
					.collect(Collectors.toList());
			List<String> type = existCustomer.getTelephoneNumbers().stream().map(p -> p.getType())
					.collect(Collectors.toList());
			customers.setEnergyAccounts(String.join(",", existCustomer.getEnergyAccounts()));
			customers = mapper1.map(existCustomer, Customers.class);
			customers.setNumber(String.join(",", number));
			customers.setType(String.join(",", type));
			repo.save(customers);
		}
		return;
	}
}
