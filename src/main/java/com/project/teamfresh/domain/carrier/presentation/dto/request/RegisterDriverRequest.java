package com.project.teamfresh.domain.carrier.presentation.dto.request;

import com.project.teamfresh.domain.carrier.domain.Driver;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterDriverRequest {

    private Long carrierId;
    private String name;
    private String number;

    public Driver toEntity() {
        return Driver.builder()
                .name(this.name)
                .number(this.number)
                .build();
    }

}
