package com.project.teamfresh.domain.customer.presentation;

import com.project.teamfresh.domain.customer.presentation.dto.request.RegisterKeeperRequest;
import com.project.teamfresh.domain.customer.service.RegisterKeeperService;
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
public class KeeperController {

    private final RegisterKeeperService registerKeeperService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerKeeper(
            @RequestBody RegisterKeeperRequest request
    ) {
        registerKeeperService.execute(request);
    }

}
