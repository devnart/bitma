package com.hamza.bitma.dto.model;

import com.hamza.bitma.enumeration.RoomType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class OfferDto {
    private Long id;
    private String userId;
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
