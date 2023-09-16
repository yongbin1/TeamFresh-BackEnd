package com.project.teamfresh.domain.compensation.exception.error;

import com.project.teamfresh.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CompensationErrorProperty implements ErrorProperty {

    COMPENSATION_NOT_FOUND(HttpStatus.NOT_FOUND, "배상 정보를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;

}
