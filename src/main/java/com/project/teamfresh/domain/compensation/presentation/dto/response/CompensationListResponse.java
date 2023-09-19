package com.project.teamfresh.domain.compensation.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @Builder
@AllArgsConstructor
public class CompensationListResponse {

    private List<CompensationResponse> list;

}
