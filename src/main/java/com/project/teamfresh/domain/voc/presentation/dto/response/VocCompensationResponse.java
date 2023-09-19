package com.project.teamfresh.domain.voc.presentation.dto.response;

import com.project.teamfresh.domain.compensation.domain.Compensation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class VocCompensationResponse {

    private String content;
    private Integer price;

    public static VocCompensationResponse of(Compensation compensation) {
        return VocCompensationResponse.builder()
                .content(compensation.getContent())
                .price(compensation.getPrice())
                .build();
    }

}
