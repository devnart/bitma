package com.hamza.bitma.controller;

import com.hamza.bitma.dto.model.DemandDto;
import com.hamza.bitma.service.DemandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public DemandDto createDemand(@RequestBody DemandDto demandDto) {
        return demandService.createDemand(demandDto);
    }
}
