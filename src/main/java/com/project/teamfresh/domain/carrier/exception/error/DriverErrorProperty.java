package com.project.teamfresh.domain.carrier.exception.error;

import com.project.teamfresh.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum DriverErrorProperty implements ErrorProperty {

    DRIVER_NOT_FOUND(HttpStatus.NOT_FOUND, "기사를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;

}