package com.project.teamfresh.domain.customer.facade;

import com.project.teamfresh.domain.customer.domain.Customer;
import com.project.teamfresh.domain.customer.domain.repository.CustomerRepository;
import com.project.teamfresh.domain.customer.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CustomerFacade {

    private final CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> CustomerNotFoundException.EXCEPTION);
    }

}
