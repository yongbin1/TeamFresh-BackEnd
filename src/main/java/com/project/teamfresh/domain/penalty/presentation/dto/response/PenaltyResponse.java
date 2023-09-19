package com.project.teamfresh.domain.penalty.presentation.dto.response;

import com.project.teamfresh.domain.carrier.presentation.dto.response.DriverResponse;
import com.project.teamfresh.domain.penalty.domain.Penalty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class PenaltyResponse {

    private String content;
    private DriverResponse driver;

    public static PenaltyResponse of(Penalty penalty) {
        return PenaltyResponse.builder()
                .content(penalty.getContent())
                .driver(DriverResponse.of(penalty.getDriver()))
                .build();
    }

}
