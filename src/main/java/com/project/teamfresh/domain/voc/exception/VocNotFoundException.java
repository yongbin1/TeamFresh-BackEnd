package com.project.teamfresh.domain.voc.exception;

import com.project.teamfresh.domain.voc.exception.error.VocErrorProperty;
import com.project.teamfresh.global.exception.BusinessException;

public class VocNotFoundException extends BusinessException {

    public static final VocNotFoundException EXCEPTION = new VocNotFoundException();

    private VocNotFoundException() {
        super(VocErrorProperty.VOC_NOT_FOUND);
    }
}
