package com.project.teamfresh.domain.penalty.service;

import com.project.teamfresh.domain.carrier.domain.Driver;
import com.project.teamfresh.domain.carrier.facade.DriverFacade;
import com.project.teamfresh.domain.compensation.domain.Compensation;
import com.project.teamfresh.domain.compensation.facade.CompensationFacade;
import com.project.teamfresh.domain.penalty.domain.Penalty;
import com.project.teamfresh.domain.penalty.presentation.dto.request.CreatePenaltyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreatePenaltyService {

    private final DriverFacade driverFacade;
    private final CompensationFacade compensationFacade;

    @Transactional
    public void execute(Long compensationId, CreatePenaltyRequest request) {
        Driver driver = driverFacade.getDriver(request.getDriverId());
        Compensation compensation = compensationFacade.getCompensation(compensationId);

        Penalty penalty = request.toEntity();
        driver.addPenalty(penalty);
        compensation.setPenalty(penalty);
    }

}
