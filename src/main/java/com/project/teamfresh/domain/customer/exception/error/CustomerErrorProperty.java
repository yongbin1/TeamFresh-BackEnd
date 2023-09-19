package com.project.teamfresh.domain.customer.exception.error;

import com.project.teamfresh.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CustomerErrorProperty implements ErrorProperty {

    CUSTOMER_NOT_FOUND(HttpStatus.NOT_FOUND, "고객사를 찾을 수 없습니다."),
    ALREADY_CUSTOMER_ID(HttpStatus.CONFLICT, "고객사 ID가 이미 사용 중입니다.");

    private final HttpStatus status;
    private final String message;

}
