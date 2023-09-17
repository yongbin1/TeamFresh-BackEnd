package com.project.teamfresh.domain.voc.service;

import com.project.teamfresh.domain.voc.domain.VOC;
import com.project.teamfresh.domain.voc.domain.repository.VocRepository;
import com.project.teamfresh.domain.voc.presentation.dto.request.CreateVocRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateVocService {

    private final VocRepository vocRepository;

    @Transactional
    public void execute(CreateVocRequest request) {
        VOC voc = request.toEntity();
        vocRepository.save(voc);
    }

}
