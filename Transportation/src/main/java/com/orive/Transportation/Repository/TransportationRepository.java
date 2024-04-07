package com.orive.Transportation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Transportation.Entity.TransportationDetails;

public interface TransportationRepository extends JpaRepository<TransportationDetails, Long>{

}
