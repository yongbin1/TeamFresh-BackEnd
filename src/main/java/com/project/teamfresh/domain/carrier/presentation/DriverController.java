package com.project.teamfresh.domain.carrier.presentation;

import com.project.teamfresh.domain.carrier.presentation.dto.request.RegisterDriverRequest;
import com.project.teamfresh.domain.carrier.service.RegisterDriverService;
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
@RequestMapping(value = "/driver")
@Tag(name = "기사 서버")
public class DriverController {

    private final RegisterDriverService registerDriverService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "기사 정보 등록 API")
    public void registerDriver(
            @RequestBody RegisterDriverRequest request
    ) {
        registerDriverService.execute(request);
    }

}
