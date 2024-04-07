package com.orive.Supplier.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.orive.Supplier.Entity.IndividualSupplierDetails;

public interface IndividualSupplierRepositoy extends JpaRepository<IndividualSupplierDetails, Long>{

	Optional<IndividualSupplierDetails> findBySupplierName(String supplierName);
}
