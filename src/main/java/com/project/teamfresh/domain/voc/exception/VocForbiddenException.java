package com.project.teamfresh.domain.voc.exception;

import com.project.teamfresh.domain.voc.exception.error.VocErrorProperty;
import com.project.teamfresh.global.exception.BusinessException;

public class VocForbiddenException extends BusinessException {

    public static final VocForbiddenException EXCEPTION = new VocForbiddenException();

    private VocForbiddenException() {
        super(VocErrorProperty.VOC_FORBIDDEN);
    }
}
