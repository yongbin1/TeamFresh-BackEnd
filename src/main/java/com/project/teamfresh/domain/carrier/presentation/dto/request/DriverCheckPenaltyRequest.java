package com.project.teamfresh.domain.carrier.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DriverCheckPenaltyRequest {

    private Long vocId;
    private Boolean objection;

}
