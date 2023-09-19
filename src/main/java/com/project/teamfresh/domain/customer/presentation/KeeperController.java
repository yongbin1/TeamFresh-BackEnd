package com.project.teamfresh.domain.customer.presentation;

import com.project.teamfresh.domain.customer.presentation.dto.request.RegisterKeeperRequest;
import com.project.teamfresh.domain.customer.service.RegisterKeeperService;
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
@RequestMapping(value = "/keeper")
@Tag(name = "담당자 서버")
public class KeeperController {

    private final RegisterKeeperService registerKeeperService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "담당자 정보 등록 API")
    public void registerKeeper(
            @RequestBody RegisterKeeperRequest request
    ) {
        registerKeeperService.execute(request);
    }

}
