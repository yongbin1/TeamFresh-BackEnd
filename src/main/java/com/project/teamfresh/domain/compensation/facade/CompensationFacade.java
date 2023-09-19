package com.project.teamfresh.domain.compensation.facade;

import com.project.teamfresh.domain.compensation.domain.Compensation;
import com.project.teamfresh.domain.compensation.domain.repository.CompensationRepository;
import com.project.teamfresh.domain.compensation.exception.CompensationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CompensationFacade {

    private final CompensationRepository compensationRepository;

    @Transactional(readOnly = true)
    public Compensation getCompensation(Long id) {
        return compensationRepository.findById(id)
                .orElseThrow(() -> CompensationNotFoundException.EXCEPTION);
    }

    @Transactional(readOnly = true)
    public List<Compensation> getAllCompensation() {
        return compensationRepository.findAll();
    }

}
