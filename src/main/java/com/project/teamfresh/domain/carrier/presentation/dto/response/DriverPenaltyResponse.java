package com.project.teamfresh.domain.carrier.presentation.dto.response;

import com.project.teamfresh.domain.compensation.presentation.dto.response.CompensationVocResponse;
import com.project.teamfresh.domain.penalty.domain.Penalty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @Builder
@AllArgsConstructor
public class DriverPenaltyResponse {

    private String content;
    private Boolean check;
    private Boolean objection;
    private DriverCompensationResponse compensation;

    public static DriverPenaltyResponse of(Penalty penalty) {
        return DriverPenaltyResponse.builder()
                .content(penalty.getContent())
                .check(penalty.getCompensation().getVoc().getDriverCheck())
                .objection(penalty.getCompensation().getVoc().getObjection())
                .compensation(DriverCompensationResponse.of(penalty.getCompensation()))
                .build();
    }

}
