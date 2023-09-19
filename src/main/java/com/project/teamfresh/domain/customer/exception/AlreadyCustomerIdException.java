package com.project.teamfresh.domain.customer.exception;

import com.project.teamfresh.domain.customer.exception.error.CustomerErrorProperty;
import com.project.teamfresh.global.exception.BusinessException;

public class AlreadyCustomerIdException extends BusinessException {

    public static final AlreadyCustomerIdException EXCEPTION = new AlreadyCustomerIdException();

    private AlreadyCustomerIdException() {
        super(CustomerErrorProperty.ALREADY_CUSTOMER_ID);
    }
}
