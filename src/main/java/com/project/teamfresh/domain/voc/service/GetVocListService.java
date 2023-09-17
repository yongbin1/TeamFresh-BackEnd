package com.project.teamfresh.domain.voc.service;

import com.project.teamfresh.domain.voc.domain.VOC;
import com.project.teamfresh.domain.voc.facade.VocFacade;
import com.project.teamfresh.domain.voc.presentation.dto.response.VocListResponse;
import com.project.teamfresh.domain.voc.presentation.dto.response.VocResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetVocListService {

    private final VocFacade vocFacade;

    @Transactional
    public VocListResponse execute() {
        List<VOC> vocList = vocFacade.getAllVoc();

        List<VocResponse> list = vocList.stream()
                .map(VocResponse::of)
                .toList();

        return VocListResponse.builder()
                .list(list)
                .build();
    }

}
