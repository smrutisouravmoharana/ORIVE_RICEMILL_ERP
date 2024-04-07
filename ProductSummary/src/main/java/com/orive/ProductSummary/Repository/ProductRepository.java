package com.orive.ProductSummary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.ProductSummary.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
