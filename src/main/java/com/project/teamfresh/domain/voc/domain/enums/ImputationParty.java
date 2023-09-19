package com.project.teamfresh.domain.voc.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ImputationParty {

    CUSTOMER("고객사"),
    CARRIER("운송사");

    private final String party;

}
