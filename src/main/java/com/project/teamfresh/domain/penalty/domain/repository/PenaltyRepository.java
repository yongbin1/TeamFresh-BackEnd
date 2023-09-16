package com.project.teamfresh.domain.penalty.domain.repository;

import com.project.teamfresh.domain.penalty.domain.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenaltyRepository extends JpaRepository<Penalty, Long> {
}
