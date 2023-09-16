package com.project.teamfresh.domain.customer.domain.repository;

import com.project.teamfresh.domain.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
