package com.project.teamfresh.domain.carrier.facade;

import com.project.teamfresh.domain.carrier.domain.Driver;
import com.project.teamfresh.domain.carrier.domain.repository.DriverRepository;
import com.project.teamfresh.domain.carrier.exception.AlreadyDriverIdException;
import com.project.teamfresh.domain.carrier.exception.DriverNotFoundException;
import com.project.teamfresh.domain.penalty.domain.Penalty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DriverFacade {

    private final DriverRepository driverRepository;

    @Transactional(readOnly = true)
    public Driver getDriver(String driverId) {
        return driverRepository.findByDriverId(driverId)
                .orElseThrow(() -> DriverNotFoundException.EXCEPTION);
    }

    @Transactional(readOnly = true)
    public void existsDriver(String id) {
        if (driverRepository.existsByDriverId(id))
            throw AlreadyDriverIdException.EXCEPTION;
    }

}
