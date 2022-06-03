package com.hamza.bitma.controller;

import com.hamza.bitma.dto.model.DemandDto;
import com.hamza.bitma.entity.Demand;
import com.hamza.bitma.service.DemandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demand")
@RequiredArgsConstructor
public class DemandController {

    private final DemandService demandService;

    @GetMapping("/all")
    public List<DemandDto> getAllDemands() {
        return demandService.getAllDemands();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Demand createDemand(@RequestBody Demand demandDto) {
        return demandService.createDemand(demandDto);
    }

    @GetMapping("/user/{id}")
    public List<DemandDto> getDemandsByUserId(@PathVariable Long id) {
        return demandService.getAllDemandsByUserId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDemand(@PathVariable Long id) {
        demandService.deleteDemand(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> updateDemand(@PathVariable Long id, @RequestBody DemandDto demandDto) {
        return demandService.updateDemand(id, demandDto);
    }
}
