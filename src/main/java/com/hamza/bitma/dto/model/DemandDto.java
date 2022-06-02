package com.hamza.bitma.dto.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class DemandDto {
    private String id;
    private String userId;
    private String title;
    private String description;
    private String city;
    private Double budget;
    private String roomType;
    private Boolean availability;
    private Date availableFrom;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
