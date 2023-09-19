package com.project.teamfresh.domain.voc.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ImputationParty {

    CUSTOMER("CUSTOMER"),
    CARRIER("CARRIER");

    private final String party;

}
