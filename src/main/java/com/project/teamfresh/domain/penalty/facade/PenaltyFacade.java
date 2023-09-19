package com.project.teamfresh.domain.penalty.facade;

import com.project.teamfresh.domain.penalty.domain.repository.PenaltyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PenaltyFacade {

    private final PenaltyRepository penaltyRepository;

}
