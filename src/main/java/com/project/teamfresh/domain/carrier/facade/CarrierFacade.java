package com.project.teamfresh.domain.carrier.facade;

import com.project.teamfresh.domain.carrier.domain.Carrier;
import com.project.teamfresh.domain.carrier.domain.repository.CarrierRepository;
import com.project.teamfresh.domain.carrier.exception.CarrierNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CarrierFacade {

    private final CarrierRepository carrierRepository;

    @Transactional(readOnly = true)
    public Carrier getCarrier(Long id) {
        return carrierRepository.findById(id)
                .orElseThrow(() -> CarrierNotFoundException.EXCEPTION);
    }

}
