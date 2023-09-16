package com.project.teamfresh.domain.customer.exception;

import com.project.teamfresh.domain.customer.exception.error.CustomerErrorProperty;
import com.project.teamfresh.global.exception.BusinessException;

public class CustomerNotFoundException extends BusinessException {

    public static final CustomerNotFoundException EXCEPTION = new CustomerNotFoundException();

    private CustomerNotFoundException() {
        super(CustomerErrorProperty.CUSTOMER_NOT_FOUND);
    }
}
