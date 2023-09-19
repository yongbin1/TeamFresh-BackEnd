package com.project.teamfresh.domain.voc.exception;

import com.project.teamfresh.domain.voc.exception.error.VocErrorProperty;
import com.project.teamfresh.global.exception.BusinessException;

public class AlreadyCheckVocException extends BusinessException {

    public static final AlreadyCheckVocException EXCEPTION = new AlreadyCheckVocException();

    private AlreadyCheckVocException() {
        super(VocErrorProperty.ALREADY_CHECK_VOC);
    }
}
