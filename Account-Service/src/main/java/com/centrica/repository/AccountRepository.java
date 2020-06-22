package com.centrica.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.centrica.model.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, String> {
	Optional<Accounts> findById(String id);
}