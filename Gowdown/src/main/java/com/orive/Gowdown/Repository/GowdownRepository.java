package com.orive.Gowdown.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Gowdown.Entity.GowdownDetails;

public interface GowdownRepository extends JpaRepository<GowdownDetails, Long>{

}
