package com.project.teamfresh.domain.penalty.exception;

import com.project.teamfresh.domain.penalty.exception.error.PenaltyErrorProperty;
import com.project.teamfresh.global.exception.BusinessException;

public class PenaltyNotFoundException extends BusinessException {

    public static final PenaltyNotFoundException EXCEPTION = new PenaltyNotFoundException();

    private PenaltyNotFoundException() {
        super(PenaltyErrorProperty.PENALTY_NOT_FOUND);
    }
}
