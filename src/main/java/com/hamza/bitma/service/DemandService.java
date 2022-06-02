package com.hamza.bitma.service;

import com.hamza.bitma.entity.Demand;
import com.hamza.bitma.repository.DemandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DemandService {


    private final DemandRepository demandRepository;

    public void save(Demand demand) {
        log.info("DemandService.save()");
        demandRepository.save(demand);
    }
}
