package com.project.teamfresh.domain.carrier.domain.repository;

import com.project.teamfresh.domain.carrier.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByDriverId(String driverId);

}
