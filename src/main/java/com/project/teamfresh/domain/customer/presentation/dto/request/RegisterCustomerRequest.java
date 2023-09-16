package com.project.teamfresh.domain.customer.presentation.dto.request;

import com.project.teamfresh.domain.customer.domain.Customer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterCustomerRequest {

    private String name;
    private String number;

    public Customer toEntity() {
        return Customer.builder()
                .name(this.name)
                .number(this.number)
                .build();
    }

}
