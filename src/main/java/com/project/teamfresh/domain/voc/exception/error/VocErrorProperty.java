package com.project.teamfresh.domain.voc.exception.error;

import com.project.teamfresh.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum VocErrorProperty implements ErrorProperty {

    VOC_NOT_FOUND(HttpStatus.NOT_FOUND, "VOC 정보를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;

}
