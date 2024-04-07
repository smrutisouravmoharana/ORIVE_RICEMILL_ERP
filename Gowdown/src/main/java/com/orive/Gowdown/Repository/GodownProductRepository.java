package com.orive.Gowdown.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Gowdown.Entity.GodownProductDetails;

public interface GodownProductRepository extends JpaRepository<GodownProductDetails, Long>{

}
