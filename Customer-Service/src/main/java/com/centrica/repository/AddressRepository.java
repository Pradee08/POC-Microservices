package com.centrica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.centrica.model.CorrespondenceAddress;

public interface AddressRepository extends JpaRepository<CorrespondenceAddress, Integer> {
}
