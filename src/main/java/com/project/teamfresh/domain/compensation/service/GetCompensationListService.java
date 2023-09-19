package com.project.teamfresh.domain.compensation.service;

import com.project.teamfresh.domain.compensation.domain.Compensation;
import com.project.teamfresh.domain.compensation.facade.CompensationFacade;
import com.project.teamfresh.domain.compensation.presentation.dto.response.CompensationListResponse;
import com.project.teamfresh.domain.compensation.presentation.dto.response.CompensationResponse;
import com.project.teamfresh.domain.compensation.presentation.dto.response.CompensationVocResponse;
import com.project.teamfresh.domain.penalty.presentation.dto.response.PenaltyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCompensationListService {

    private final CompensationFacade compensationFacade;

    @Transactional
    public CompensationListResponse execute() {
        List<Compensation> compensationList = compensationFacade.getAllCompensation();

        List<CompensationResponse> list = compensationList.stream()
                .map(item -> {
                    if (item.getPenalty() == null) {
                        return CompensationResponse.of(item, CompensationVocResponse.of(item.getVoc(), null));
                    } else {
                        return CompensationResponse.of(item, CompensationVocResponse.of(item.getVoc(), PenaltyResponse.of(item.getPenalty())));
                    }
                })
                .toList();

        return CompensationListResponse.builder()
                .list(list)
                .build();
    }

}
