package com.project.teamfresh.domain.carrier.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @Builder
@AllArgsConstructor
public class DriverPenaltyListResponse {

    private List<DriverPenaltyResponse> list;

}
