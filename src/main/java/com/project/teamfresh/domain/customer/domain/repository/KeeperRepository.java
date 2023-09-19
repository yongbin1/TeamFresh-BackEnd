package com.project.teamfresh.domain.customer.domain.repository;

import com.project.teamfresh.domain.customer.domain.Keeper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KeeperRepository extends JpaRepository<Keeper, Long> {

    Optional<Keeper> findByKeeperId(String keeperId);

}
