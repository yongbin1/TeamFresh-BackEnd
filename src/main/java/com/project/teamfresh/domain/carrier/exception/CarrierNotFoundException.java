package com.project.teamfresh.domain.carrier.exception;

import com.project.teamfresh.domain.carrier.exception.error.CarrierErrorProperty;
import com.project.teamfresh.global.exception.BusinessException;

public class CarrierNotFoundException extends BusinessException {

    public static final CarrierNotFoundException EXCEPTION = new CarrierNotFoundException();

    private CarrierNotFoundException() {
        super(CarrierErrorProperty.CARRIER_NOT_FOUND);
    }
}
