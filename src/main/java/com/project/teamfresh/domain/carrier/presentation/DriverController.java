package com.project.teamfresh.domain.carrier.presentation;

import com.project.teamfresh.domain.carrier.presentation.dto.request.RegisterDriverRequest;
import com.project.teamfresh.domain.carrier.service.RegisterDriverService;
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
public class DriverController {

    private final RegisterDriverService registerDriverService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerDriver(
            @RequestBody RegisterDriverRequest request
    ) {
        registerDriverService.execute(request);
    }

}
