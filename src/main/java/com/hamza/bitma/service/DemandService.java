package com.hamza.bitma.service;

import com.hamza.bitma.dto.mapperInterface.IMapperDto;
import com.hamza.bitma.dto.model.DemandDto;
import com.hamza.bitma.entity.Demand;
import com.hamza.bitma.enumeration.RoomType;
import com.hamza.bitma.repository.DemandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Demand createDemand(Demand demand) {
        log.info("DemandService.createDemand()" + demand);
//        Demand demand = demandMapper.convertToEntity(demandDto, Demand.class);

        return demandRepository.save(demand);
//        return demandMapper.convertToDto(demand, DemandDto.class);
    }

    public List<DemandDto> getAllDemandsByUserId(Long userId) {
        log.info("DemandService.getAllDemandsByUserId()");
        List<Demand> demands = demandRepository.findAllByUserId(userId);
        return demandMapper.convertListToListDto(demands, DemandDto.class);
    }

    public void deleteDemand(Long id) {
        log.info("DemandService.deleteDemand()");
        demandRepository.deleteById(id);
    }

    public ResponseEntity<String> updateDemand(Long id, DemandDto demandDto) {
        log.info("DemandService.updateDemand()");

        Optional<Demand> demand = demandRepository.findById(id);

        if (demand.isEmpty()) {
            return ResponseEntity.status(404).body("Demand not found");
        }

        demand.get().setTitle(demandDto.getTitle());
        demand.get().setDescription(demandDto.getDescription());
        demand.get().setAvailability(demandDto.getAvailability());
        demand.get().setBudget(demandDto.getBudget());
        demand.get().setAvailableFrom(demandDto.getAvailableFrom());
        demand.get().setCity(demandDto.getCity());
        demand.get().setRoomType(RoomType.valueOf(demandDto.getRoomType()));

        demandRepository.save(demand.get());
        return ResponseEntity.ok("Demand updated successfully");
    }
}
