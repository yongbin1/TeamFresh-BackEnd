package com.project.teamfresh.domain.carrier.service;

import com.project.teamfresh.domain.carrier.domain.Carrier;
import com.project.teamfresh.domain.carrier.domain.Driver;
import com.project.teamfresh.domain.carrier.domain.repository.DriverRepository;
import com.project.teamfresh.domain.carrier.facade.CarrierFacade;
import com.project.teamfresh.domain.carrier.facade.DriverFacade;
import com.project.teamfresh.domain.carrier.presentation.dto.request.RegisterDriverRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterDriverService {

    private final CarrierFacade carrierFacade;
    private final DriverFacade driverFacade;

    @Transactional
    public void execute(RegisterDriverRequest request) {
        driverFacade.existsDriver(request.getCarrierId());

        Carrier carrier = carrierFacade.getCarrier(request.getCarrierId());
        Driver driver = request.toEntity();

        carrier.addDriver(driver);
    }

}
