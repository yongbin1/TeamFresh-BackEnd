package com.project.teamfresh.domain.penalty.presentation;

import com.project.teamfresh.domain.penalty.presentation.dto.request.CreatePenaltyRequest;
import com.project.teamfresh.domain.penalty.service.CreatePenaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/penalty")
public class PenaltyController {

    private final CreatePenaltyService createPenaltyService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPenalty(
            @RequestParam("compensation_id") Long compensationId,
            @RequestBody CreatePenaltyRequest request
    ) {
        createPenaltyService.execute(compensationId, request);
    }

}
