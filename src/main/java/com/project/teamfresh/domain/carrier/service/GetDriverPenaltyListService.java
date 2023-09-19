package com.project.teamfresh.domain.carrier.service;

import com.project.teamfresh.domain.carrier.domain.Driver;
import com.project.teamfresh.domain.carrier.facade.DriverFacade;
import com.project.teamfresh.domain.carrier.presentation.dto.response.DriverPenaltyListResponse;
import com.project.teamfresh.domain.carrier.presentation.dto.response.DriverPenaltyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetDriverPenaltyListService {

    private final DriverFacade driverFacade;

    @Transactional
    public DriverPenaltyListResponse execute(String driverId) {
        Driver driver = driverFacade.getDriver(driverId);

        List<DriverPenaltyResponse> list = driver.getPenaltyList().stream()
                .map(DriverPenaltyResponse::of)
                .collect(Collectors.toList());

        return DriverPenaltyListResponse.builder()
                .list(list)
                .build();
    }

}
