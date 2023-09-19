package com.project.teamfresh.domain.customer.presentation;

import com.project.teamfresh.domain.customer.presentation.dto.request.RegisterCustomerRequest;
import com.project.teamfresh.domain.customer.service.RegisterCustomerService;
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
@RequestMapping(value = "/customer")
@Tag(name = "고객사 서버")
public class CustomerController {

    private final RegisterCustomerService registerCustomerService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "고객사 정보 등록 API")
    public void registerCustomer(
            @RequestBody RegisterCustomerRequest request
    ) {
        registerCustomerService.execute(request);
    }

}
