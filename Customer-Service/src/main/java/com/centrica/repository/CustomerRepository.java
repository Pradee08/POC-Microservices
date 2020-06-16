package com.centrica.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.centrica.model.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Integer> {
	List<Customers> findByUcrn(String ucrn);
	Customers findById(int id);
}
