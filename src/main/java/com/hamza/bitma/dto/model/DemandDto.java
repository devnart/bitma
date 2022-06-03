package com.hamza.bitma.dto.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class DemandDto {
    private long id;
//    private long user;
    private String title;
    private String description;
    private String city;
    private Double budget;
    private String roomType;
    private Boolean availability;
    private LocalDate availableFrom;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdate;
}
