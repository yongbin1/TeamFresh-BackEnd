package com.project.teamfresh.domain.compensation.exception;

import com.project.teamfresh.domain.compensation.exception.error.CompensationErrorProperty;
import com.project.teamfresh.global.exception.BusinessException;

public class CompensationNotFoundException extends BusinessException {

    public static final CompensationNotFoundException EXCEPTION = new CompensationNotFoundException();

    private CompensationNotFoundException() {
        super(CompensationErrorProperty.COMPENSATION_NOT_FOUND);
    }
}
