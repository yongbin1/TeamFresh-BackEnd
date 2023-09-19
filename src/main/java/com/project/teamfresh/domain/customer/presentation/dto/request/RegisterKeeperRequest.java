package com.project.teamfresh.domain.customer.presentation.dto.request;

import com.project.teamfresh.domain.customer.domain.Keeper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterKeeperRequest {

    private String customerId;
    private String keeperId;
    private String name;
    private String number;

    public Keeper toEntity() {
        return Keeper.builder()
                .keeperId(this.keeperId)
                .name(this.name)
                .number(this.number)
                .build();
    }

}
