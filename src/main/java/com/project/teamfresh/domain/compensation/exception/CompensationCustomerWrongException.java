package com.project.teamfresh.domain.compensation.exception;

import com.project.teamfresh.domain.compensation.exception.error.CompensationErrorProperty;
import com.project.teamfresh.global.exception.BusinessException;

public class CompensationCustomerWrongException extends BusinessException {

    public static final CompensationCustomerWrongException EXCEPTION = new CompensationCustomerWrongException();

    private CompensationCustomerWrongException() {
        super(CompensationErrorProperty.COMPENSATION_CUSTOMER_WRONG);
    }
}
