package com.project.teamfresh.domain.customer.exception.error;

import com.project.teamfresh.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum KeeperErrorProperty implements ErrorProperty {

    KEEPER_NOT_FOUND(HttpStatus.NOT_FOUND, "담당자를 찾을 수 없습니다."),
    ALREADY_KEEPER_ID(HttpStatus.CONFLICT, "담당자 ID가 이미 사용 중 입니다.");

    private final HttpStatus status;
    private final String message;

}
