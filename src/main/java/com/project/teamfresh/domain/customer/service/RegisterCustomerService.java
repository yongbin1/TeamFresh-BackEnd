package com.project.teamfresh.domain.customer.service;

import com.project.teamfresh.domain.customer.domain.repository.CustomerRepository;
import com.project.teamfresh.domain.customer.presentation.dto.request.RegisterCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterCustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public void execute(RegisterCustomerRequest request) {
        customerRepository.save(request.toEntity());
    }

}
