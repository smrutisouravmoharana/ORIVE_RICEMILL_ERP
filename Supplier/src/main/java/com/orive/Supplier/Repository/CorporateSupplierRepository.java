package com.orive.Supplier.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Supplier.Entity.CorporateSupplierDetails;

public interface CorporateSupplierRepository extends JpaRepository<CorporateSupplierDetails, Long>{

	Optional<CorporateSupplierDetails> findBySupplierName(String supplierName);
}
