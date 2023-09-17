package com.project.teamfresh.domain.voc.presentation.dto.response;

import com.project.teamfresh.domain.compensation.presentation.dto.response.CompensationResponse;
import com.project.teamfresh.domain.penalty.presentation.dto.response.PenaltyResponse;
import com.project.teamfresh.domain.voc.domain.VOC;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class VocResponse {

    private Long idx;
    private String imputationParty;
    private String imputationContent;
    private Boolean driverCheck;
    private Boolean objection;
    private PenaltyResponse penalty;
    private CompensationResponse compensation;

    public static VocResponse of(VOC voc) {
        return VocResponse.builder()
                .idx(voc.getIdx())
                .imputationParty(voc.getImputationParty())
                .imputationContent(voc.getImputationContent())
                .driverCheck(voc.getDriverCheck())
                .objection(voc.getObjection())
                .penalty(PenaltyResponse.of(voc.getPenalty()))
                .compensation(CompensationResponse.of(voc.getCompensation()))
                .build();
    }

}
