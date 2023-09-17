package com.project.teamfresh.domain.voc.facade;

import com.project.teamfresh.domain.voc.domain.VOC;
import com.project.teamfresh.domain.voc.domain.repository.VocRepository;
import com.project.teamfresh.domain.voc.exception.VocNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VocFacade {

    private final VocRepository vocRepository;

    @Transactional(readOnly = true)
    public VOC getVoc(Long id) {
        return vocRepository.findById(id)
                .orElseThrow(() -> VocNotFoundException.EXCEPTION);
    }

    @Transactional(readOnly = true)
    public List<VOC> getAllVoc() {
        return vocRepository.findAll();
    }

}
