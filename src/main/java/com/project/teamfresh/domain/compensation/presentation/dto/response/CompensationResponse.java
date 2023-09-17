package com.project.teamfresh.domain.compensation.presentation.dto.response;

import com.project.teamfresh.domain.compensation.domain.Compensation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class CompensationResponse {

    private Long idx;
    private String content;
    private Integer price;

    public static CompensationResponse of(Compensation compensation) {
        return CompensationResponse.builder()
                .idx(compensation.getIdx())
                .content(compensation.getContent())
                .price(compensation.getPrice())
                .build();
    }

}
