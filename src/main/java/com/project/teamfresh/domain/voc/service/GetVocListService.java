package com.project.teamfresh.domain.voc.service;

import com.project.teamfresh.domain.compensation.domain.Compensation;
import com.project.teamfresh.domain.compensation.exception.CompensationNotFoundException;
import com.project.teamfresh.domain.penalty.exception.PenaltyNotFoundException;
import com.project.teamfresh.domain.penalty.presentation.dto.response.PenaltyResponse;
import com.project.teamfresh.domain.voc.domain.VOC;
import com.project.teamfresh.domain.voc.domain.enums.ImputationParty;
import com.project.teamfresh.domain.voc.facade.VocFacade;
import com.project.teamfresh.domain.voc.presentation.dto.response.VocCompensationResponse;
import com.project.teamfresh.domain.voc.presentation.dto.response.VocListResponse;
import com.project.teamfresh.domain.voc.presentation.dto.response.VocResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetVocListService {

    private final VocFacade vocFacade;

    @Transactional
    public VocListResponse execute() {
        List<VOC> vocList = vocFacade.getAllVoc();

        List<VocResponse> list = vocList.stream()
                .map(item -> {
                    if (item.getCompensation() == null || item.getImputationParty().equals(ImputationParty.CUSTOMER)) {
                        return VocResponse.of(item, null, null);
                    } else if(item.getCompensation().getPenalty() == null) {
                        return VocResponse.of(item, null, VocCompensationResponse.of(item.getCompensation()));
                    } else {
                        return VocResponse.of(item, PenaltyResponse.of(item.getCompensation().getPenalty()),
                                VocCompensationResponse.of(item.getCompensation()));
                    }
                })
                .toList();

        return VocListResponse.builder()
                .list(list)
                .build();
    }

}
