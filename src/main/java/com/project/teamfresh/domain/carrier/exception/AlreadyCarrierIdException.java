package com.project.teamfresh.domain.carrier.exception;

import com.project.teamfresh.domain.carrier.exception.error.CarrierErrorProperty;
import com.project.teamfresh.global.exception.BusinessException;

public class AlreadyCarrierIdException extends BusinessException {

    public static final AlreadyCarrierIdException EXCEPTION = new AlreadyCarrierIdException();

    private AlreadyCarrierIdException() {
        super(CarrierErrorProperty.ALREADY_CARRIER_ID);
    }
}
