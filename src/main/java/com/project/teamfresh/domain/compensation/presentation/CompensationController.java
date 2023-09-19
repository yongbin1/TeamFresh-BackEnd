package com.project.teamfresh.domain.compensation.presentation;

import com.project.teamfresh.domain.compensation.presentation.dto.request.CreateCompensationRequest;
import com.project.teamfresh.domain.compensation.presentation.dto.response.CompensationListResponse;
import com.project.teamfresh.domain.compensation.service.CreateCompensationService;
import com.project.teamfresh.domain.compensation.service.GetCompensationListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/compensation")
@Tag(name = "배상정보 서버")
public class CompensationController {

    private final CreateCompensationService createCompensationService;
    private final GetCompensationListService getCompensationListService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "배상정보 등록 API")
    public void createCompensation(
            @RequestParam("voc_id") Long vocId,
            @RequestBody CreateCompensationRequest request
    ) {
        createCompensationService.execute(vocId, request);
    }

    @GetMapping("/list")
    @Operation(summary = "배상정보 목록 API")
    public CompensationListResponse getCompensationList() {
        return getCompensationListService.execute();
    }

}
