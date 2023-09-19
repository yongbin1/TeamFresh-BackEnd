package com.project.teamfresh.domain.carrier.presentation.dto.response;

import com.project.teamfresh.domain.compensation.domain.Compensation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class DriverCompensationResponse {

    private String content;
    private Integer price;

    public static DriverCompensationResponse of(Compensation compensation) {
        return DriverCompensationResponse.builder()
                .content(compensation.getContent())
                .price(compensation.getPrice())
                .build();
    }

}
