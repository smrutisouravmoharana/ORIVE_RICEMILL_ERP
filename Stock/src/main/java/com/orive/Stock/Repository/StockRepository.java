package com.orive.Stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Stock.Entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{

}
