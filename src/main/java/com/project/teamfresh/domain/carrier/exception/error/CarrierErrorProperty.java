package com.project.teamfresh.domain.carrier.exception.error;

import com.project.teamfresh.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CarrierErrorProperty implements ErrorProperty {

    CARRIER_NOT_FOUND(HttpStatus.NOT_FOUND, "운송사를 찾을 수 없습니다."),
    ALREADY_CARRIER_ID(HttpStatus.CONFLICT, "운송사 ID가 이미 사용 중 입니다.");

    private final HttpStatus status;
    private final String message;

}
