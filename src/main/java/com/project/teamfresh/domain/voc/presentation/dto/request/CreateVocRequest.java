package com.project.teamfresh.domain.voc.presentation.dto.request;

import com.project.teamfresh.domain.voc.domain.VOC;
import com.project.teamfresh.domain.voc.domain.enums.ImputationParty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateVocRequest {

    private ImputationParty imputationParty; // 귀책 당사자
    private String imputationContent; // 귀책 내용

    public VOC toEntity() {
        return VOC.builder()
                .imputationParty(this.imputationParty)
                .imputationContent(this.imputationContent)
                .driverCheck(false)
                .objection(false)
                .build();
    }

}
