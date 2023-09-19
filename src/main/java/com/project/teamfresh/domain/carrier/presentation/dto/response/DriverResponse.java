package com.project.teamfresh.domain.carrier.presentation.dto.response;

import com.project.teamfresh.domain.carrier.domain.Driver;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class DriverResponse {

    private Long id;
    private String driverId;
    private String name;
    private String number;

    public static DriverResponse of(Driver driver) {
        return DriverResponse.builder()
                .id(driver.getId())
                .driverId(driver.getDriverId())
                .name(driver.getName())
                .number(driver.getNumber())
                .build();
    }

}
