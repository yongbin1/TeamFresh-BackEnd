package com.project.teamfresh.domain.compensation.presentation.dto.request;

import com.project.teamfresh.domain.compensation.domain.Compensation;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateCompensationRequest {

    private String content;
    private Integer price;

    public Compensation toEntity() {
        return Compensation.builder()
                .content(this.content)
                .price(this.price)
                .build();
    }

}
