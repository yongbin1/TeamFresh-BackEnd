package com.project.teamfresh.domain.penalty.presentation.dto.request;

import com.project.teamfresh.domain.penalty.domain.Penalty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreatePenaltyRequest {

    private String content;
    private String driverId;

    public Penalty toEntity() {
        return Penalty.builder()
                .content(this.content)
                .build();
    }

}
