package com.project.teamfresh.domain.voc.presentation.dto.response;

import com.project.teamfresh.domain.compensation.domain.Compensation;
import com.project.teamfresh.domain.penalty.domain.Penalty;
import com.project.teamfresh.domain.penalty.presentation.dto.response.PenaltyResponse;
import com.project.teamfresh.domain.voc.domain.VOC;
import com.project.teamfresh.domain.voc.domain.enums.ImputationParty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class VocResponse {

    private Long idx;
    private ImputationParty imputationParty;
    private String imputationContent;
    private Boolean driverCheck;
    private Boolean objection;
    private PenaltyResponse penalty;
    private VocCompensationResponse compensation;

    public static VocResponse of(VOC voc, PenaltyResponse penalty, VocCompensationResponse compensation) {
        return VocResponse.builder()
                .idx(voc.getIdx())
                .imputationParty(voc.getImputationParty())
                .imputationContent(voc.getImputationContent())
                .driverCheck(voc.getDriverCheck())
                .objection(voc.getObjection())
                .penalty(penalty)
                .compensation(compensation)
                .build();
    }

}
