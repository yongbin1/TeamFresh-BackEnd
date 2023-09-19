package com.project.teamfresh.domain.carrier.exception;

import com.project.teamfresh.domain.carrier.exception.error.DriverErrorProperty;
import com.project.teamfresh.global.exception.BusinessException;

public class AlreadyDriverIdException extends BusinessException {

    public static final AlreadyDriverIdException EXCEPTION = new AlreadyDriverIdException();

    private AlreadyDriverIdException() {
        super(DriverErrorProperty.ALREADY_DRIVER_ID);
    }
}
