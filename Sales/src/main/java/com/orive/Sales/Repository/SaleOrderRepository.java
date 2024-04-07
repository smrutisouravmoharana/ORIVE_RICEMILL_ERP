package com.orive.Sales.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Sales.Entity.SaleOrder;

public interface SaleOrderRepository extends JpaRepository<SaleOrder, Long>{

}
