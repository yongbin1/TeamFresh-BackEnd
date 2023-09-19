package com.project.teamfresh.domain.carrier.presentation;

import com.project.teamfresh.domain.carrier.presentation.dto.request.RegisterCarrierRequest;
import com.project.teamfresh.domain.carrier.service.RegisterCarrierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/carrier")
@Tag(name = "운송사 서버")
public class CarrierController {

    private final RegisterCarrierService registerCarrierService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "운송사 정보 등록 API")
    public void registerCarrier(
            @RequestBody RegisterCarrierRequest request
    ) {
        registerCarrierService.execute(request);
    }

}
