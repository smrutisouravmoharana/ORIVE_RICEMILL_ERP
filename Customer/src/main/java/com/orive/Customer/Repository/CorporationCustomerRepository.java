package com.orive.Customer.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Customer.Entity.CorporationCustomerDetails;

public interface CorporationCustomerRepository extends JpaRepository<CorporationCustomerDetails, Long>{

	Optional<CorporationCustomerDetails> findByCustomerName(String customerName);
}
