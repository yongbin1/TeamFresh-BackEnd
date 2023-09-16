package com.project.teamfresh.domain.compensation.domain.repository;

import com.project.teamfresh.domain.compensation.domain.Compensation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompensationRepository extends JpaRepository<Compensation, Long> {
}
