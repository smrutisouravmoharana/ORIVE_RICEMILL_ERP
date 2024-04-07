package com.orive.ProductUnit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.orive.ProductUnit.Entity.UnitDetails;


public interface UnitRepository extends JpaRepository<UnitDetails, Long>{

	@Query("SELECT s FROM UnitDetails s WHERE s.unitName = :unitName")
    List<UnitDetails> findByUnitName(@Param("unitName") String unitName);
}
