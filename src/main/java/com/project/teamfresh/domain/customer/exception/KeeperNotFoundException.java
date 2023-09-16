package com.project.teamfresh.domain.customer.exception;

import com.project.teamfresh.domain.customer.exception.error.KeeperErrorProperty;
import com.project.teamfresh.global.exception.BusinessException;

public class KeeperNotFoundException extends BusinessException {

    public static final KeeperNotFoundException EXCEPTION = new KeeperNotFoundException();

    private KeeperNotFoundException() {
        super(KeeperErrorProperty.KEEPER_NOT_FOUND);
    }
}
