package com.hamza.bitma.service;

import com.hamza.bitma.dto.mapperInterface.IMapperDto;
import com.hamza.bitma.dto.model.DemandDto;
import com.hamza.bitma.entity.Demand;
import com.hamza.bitma.repository.DemandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DemandService {


    private final DemandRepository demandRepository;
    private final IMapperDto<Demand, DemandDto> demandMapper;


    public List<DemandDto> getAllDemands() {
        log.info("DemandService.getAllDemands()");
        List<Demand> demands =  demandRepository.findAll();
        return demandMapper.convertListToListDto(demands, DemandDto.class);
    }

    public DemandDto createDemand(DemandDto demandDto) {
        log.info("DemandService.createDemand()" + demandDto);
        Demand demand = demandMapper.convertToEntity(demandDto, Demand.class);
        demandRepository.save(demand);
        return demandMapper.convertToDto(demand, DemandDto.class);
    }
}
