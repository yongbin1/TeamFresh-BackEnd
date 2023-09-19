package com.project.teamfresh.domain.carrier.service;

import com.project.teamfresh.domain.carrier.domain.Driver;
import com.project.teamfresh.domain.carrier.facade.DriverFacade;
import com.project.teamfresh.domain.carrier.presentation.dto.request.DriverCheckPenaltyRequest;
import com.project.teamfresh.domain.voc.domain.VOC;
import com.project.teamfresh.domain.voc.exception.AlreadyCheckVocException;
import com.project.teamfresh.domain.voc.exception.VocForbiddenException;
import com.project.teamfresh.domain.voc.facade.VocFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DriverCheckPenaltyService {

    private final DriverFacade driverFacade;
    private final VocFacade vocFacade;

    @Transactional
    public void execute(String driverId, DriverCheckPenaltyRequest request) {
        Driver driver = driverFacade.getDriver(driverId);
        VOC voc = vocFacade.getVoc(request.getVocId());

        if (!voc.getCompensation().getPenalty().getDriver().equals(driver))
            throw VocForbiddenException.EXCEPTION;

        if (voc.getDriverCheck())
            throw AlreadyCheckVocException.EXCEPTION;
        else {
            voc.checkDriver();
            if (request.getObjection())
                voc.checkObjection();
        }

    }

}
