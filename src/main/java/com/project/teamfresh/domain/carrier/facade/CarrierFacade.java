package com.project.teamfresh.domain.carrier.facade;

import com.project.teamfresh.domain.carrier.domain.Carrier;
import com.project.teamfresh.domain.carrier.domain.repository.CarrierRepository;
import com.project.teamfresh.domain.carrier.exception.AlreadyCarrierIdException;
import com.project.teamfresh.domain.carrier.exception.CarrierNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CarrierFacade {

    private final CarrierRepository carrierRepository;

    @Transactional(readOnly = true)
    public Carrier getCarrier(String carrierId) {
        return carrierRepository.findByCarrierId(carrierId)
                .orElseThrow(() -> CarrierNotFoundException.EXCEPTION);
    }

    @Transactional(readOnly = true)
    public void existsCarrier(String id) {
        if (carrierRepository.existsByCarrierId(id))
            throw AlreadyCarrierIdException.EXCEPTION;
    }

}
