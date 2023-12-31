package com.project.teamfresh.domain.customer.service;

import com.project.teamfresh.domain.customer.domain.Customer;
import com.project.teamfresh.domain.customer.domain.Keeper;
import com.project.teamfresh.domain.customer.facade.CustomerFacade;
import com.project.teamfresh.domain.customer.facade.KeeperFacade;
import com.project.teamfresh.domain.customer.presentation.dto.request.RegisterKeeperRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterKeeperService {

    private final CustomerFacade customerFacade;
    private final KeeperFacade keeperFacade;

    @Transactional
    public void execute(RegisterKeeperRequest request) {
        keeperFacade.existsKeeper(request.getKeeperId());

        Customer customer = customerFacade.getCustomer(request.getCustomerId());
        Keeper keeper = request.toEntity();

        customer.addKeeper(keeper);
    }

}
