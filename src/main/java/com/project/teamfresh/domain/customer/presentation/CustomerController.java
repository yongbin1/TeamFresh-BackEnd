package com.project.teamfresh.domain.customer.presentation;

import com.project.teamfresh.domain.customer.presentation.dto.request.RegisterCustomerRequest;
import com.project.teamfresh.domain.customer.service.RegisterCustomerService;
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
public class CustomerController {

    private final RegisterCustomerService registerCustomerService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerCustomer(
            @RequestBody RegisterCustomerRequest request
    ) {
        registerCustomerService.execute(request);
    }

}
