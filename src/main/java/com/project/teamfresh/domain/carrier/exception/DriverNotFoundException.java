package com.project.teamfresh.domain.carrier.exception;

import com.project.teamfresh.domain.carrier.exception.error.DriverErrorProperty;
import com.project.teamfresh.global.exception.BusinessException;

public class DriverNotFoundException extends BusinessException {

    public static final DriverNotFoundException EXCEPTION = new DriverNotFoundException();

    private DriverNotFoundException() {
        super(DriverErrorProperty.DRIVER_NOT_FOUND);
    }
}
