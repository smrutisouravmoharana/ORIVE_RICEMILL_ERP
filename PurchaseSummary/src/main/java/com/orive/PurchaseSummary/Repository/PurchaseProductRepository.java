package com.orive.PurchaseSummary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.PurchaseSummary.Entity.PurchaseProductDetails;

public interface PurchaseProductRepository extends JpaRepository<PurchaseProductDetails, Long>{

}
