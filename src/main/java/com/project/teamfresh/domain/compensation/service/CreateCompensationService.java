package com.project.teamfresh.domain.compensation.service;

import com.project.teamfresh.domain.compensation.domain.Compensation;
import com.project.teamfresh.domain.compensation.exception.CompensationCustomerWrongException;
import com.project.teamfresh.domain.compensation.presentation.dto.request.CreateCompensationRequest;
import com.project.teamfresh.domain.voc.domain.VOC;
import com.project.teamfresh.domain.voc.domain.enums.ImputationParty;
import com.project.teamfresh.domain.voc.facade.VocFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCompensationService {

    private final VocFacade vocFacade;

    @Transactional
    public void execute(Long vocId, CreateCompensationRequest request) {
        VOC voc = vocFacade.getVoc(vocId);

        if (voc.getImputationParty().equals(ImputationParty.CUSTOMER))
            throw CompensationCustomerWrongException.EXCEPTION;

        Compensation compensation = request.toEntity();

        voc.setCompensation(compensation);
    }

}
