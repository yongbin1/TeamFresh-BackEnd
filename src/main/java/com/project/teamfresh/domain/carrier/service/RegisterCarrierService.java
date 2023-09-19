package com.project.teamfresh.domain.carrier.service;

import com.project.teamfresh.domain.carrier.domain.repository.CarrierRepository;
import com.project.teamfresh.domain.carrier.facade.CarrierFacade;
import com.project.teamfresh.domain.carrier.presentation.dto.request.RegisterCarrierRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterCarrierService {

    private final CarrierFacade carrierFacade;
    private final CarrierRepository carrierRepository;

    @Transactional
    public void execute(RegisterCarrierRequest request) {
        carrierFacade.existsCarrier(request.getCarrierId());
        carrierRepository.save(request.toEntity());
    }

}
