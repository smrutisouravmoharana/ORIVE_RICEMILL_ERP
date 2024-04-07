package com.orive.InventoryManufacturingJournal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.InventoryManufacturingJournal.Entity.ManufactureProductEntity;

public interface ManufactureProductRepository extends JpaRepository<ManufactureProductEntity, Long>{

}
