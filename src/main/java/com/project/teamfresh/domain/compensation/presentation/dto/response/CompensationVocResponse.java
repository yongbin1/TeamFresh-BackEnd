package com.project.teamfresh.domain.compensation.presentation.dto.response;

import com.project.teamfresh.domain.penalty.presentation.dto.response.PenaltyResponse;
import com.project.teamfresh.domain.voc.domain.VOC;
import com.project.teamfresh.domain.voc.domain.enums.ImputationParty;
import com.project.teamfresh.domain.voc.presentation.dto.response.VocCompensationResponse;
import com.project.teamfresh.domain.voc.presentation.dto.response.VocResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class CompensationVocResponse {

    private String imputationParty;
    private String imputationContent;
    private Boolean driverCheck;
    private Boolean objection;
    private PenaltyResponse penalty;

    public static CompensationVocResponse of(VOC voc, PenaltyResponse penalty) {
        return CompensationVocResponse.builder()
                .imputationParty(voc.getImputationParty().getParty())
                .imputationContent(voc.getImputationContent())
                .driverCheck(voc.getDriverCheck())
                .objection(voc.getObjection())
                .penalty(penalty)
                .build();
    }

}
