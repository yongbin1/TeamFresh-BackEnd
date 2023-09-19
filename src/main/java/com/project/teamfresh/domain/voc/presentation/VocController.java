package com.project.teamfresh.domain.voc.presentation;

import com.project.teamfresh.domain.voc.presentation.dto.request.CreateVocRequest;
import com.project.teamfresh.domain.voc.presentation.dto.response.VocListResponse;
import com.project.teamfresh.domain.voc.service.CreateVocService;
import com.project.teamfresh.domain.voc.service.GetVocListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/voc")
public class VocController {

    private final CreateVocService createVocService;
    private final GetVocListService getVocListService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVoc(
            @RequestBody CreateVocRequest request
    ) {
        createVocService.execute(request);
    }

    @GetMapping("/list")
    public VocListResponse getVocList() {
        return getVocListService.execute();
    }

}
