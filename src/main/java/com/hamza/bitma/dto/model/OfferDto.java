package com.hamza.bitma.dto.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class OfferDto {
    private Long id;
    private Long user;
    private String title;
    private String description;
    private String City;
    private String Address;
    private Double price;
    private int places;
    private int rooms;
    private String roomType;
    private Boolean availability;
    private LocalDate availableFrom;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}