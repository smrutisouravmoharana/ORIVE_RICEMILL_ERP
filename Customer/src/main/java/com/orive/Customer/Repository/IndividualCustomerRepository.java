package com.orive.Customer.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.orive.Customer.Entity.IndividualCustomerDetails;


public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomerDetails, Long>{

	Optional<IndividualCustomerDetails> findByCustomerName(String customerName);
}
