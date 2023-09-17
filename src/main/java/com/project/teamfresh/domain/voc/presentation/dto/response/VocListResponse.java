package com.project.teamfresh.domain.voc.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @Builder
@AllArgsConstructor
public class VocListResponse {

    private List<VocResponse> list;

}
