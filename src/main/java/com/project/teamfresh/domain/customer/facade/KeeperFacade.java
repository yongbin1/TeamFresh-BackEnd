package com.project.teamfresh.domain.customer.facade;

import com.project.teamfresh.domain.customer.domain.Keeper;
import com.project.teamfresh.domain.customer.domain.repository.KeeperRepository;
import com.project.teamfresh.domain.customer.exception.KeeperNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class KeeperFacade {

    private final KeeperRepository keeperRepository;

    @Transactional(readOnly = true)
    public Keeper getKeeper(String id) {
        return keeperRepository.findByKeeperId(id)
                .orElseThrow(() -> KeeperNotFoundException.EXCEPTION);
    }

}
