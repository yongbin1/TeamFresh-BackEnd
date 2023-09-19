package com.project.teamfresh.domain.carrier.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class CarrierResponse {

    private Long id;
    private String carrierId;
    private String name;
    private String number;

}
