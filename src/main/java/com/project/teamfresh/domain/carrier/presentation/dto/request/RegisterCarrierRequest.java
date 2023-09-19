package com.project.teamfresh.domain.carrier.presentation.dto.request;

import com.project.teamfresh.domain.carrier.domain.Carrier;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterCarrierRequest {

    private String carrierId;
    private String name;
    private String number;

    public Carrier toEntity() {
        return Carrier.builder()
                .carrierId(this.carrierId)
                .name(this.name)
                .number(this.number)
                .build();
    }

}
