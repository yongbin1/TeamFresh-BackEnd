package com.project.teamfresh.domain.customer.exception;

import com.project.teamfresh.domain.customer.exception.error.KeeperErrorProperty;
import com.project.teamfresh.global.exception.BusinessException;

public class AlreadyKeeperIdException extends BusinessException {

    public static final AlreadyKeeperIdException EXCEPTION = new AlreadyKeeperIdException();

    private AlreadyKeeperIdException() {
        super(KeeperErrorProperty.ALREADY_KEEPER_ID);
    }
}
