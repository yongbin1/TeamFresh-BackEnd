package com.project.teamfresh.domain.carrier.domain.repository;

import com.project.teamfresh.domain.carrier.domain.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarrierRepository extends JpaRepository<Carrier, Long> {

    Optional<Carrier> findByCarrierId(String carrierId);

}
