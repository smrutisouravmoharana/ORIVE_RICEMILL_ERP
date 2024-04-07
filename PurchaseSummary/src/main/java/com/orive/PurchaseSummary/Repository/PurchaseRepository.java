package com.orive.PurchaseSummary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.PurchaseSummary.Entity.PurchaseDetails;

public interface PurchaseRepository extends JpaRepository<PurchaseDetails, Long>{

}
