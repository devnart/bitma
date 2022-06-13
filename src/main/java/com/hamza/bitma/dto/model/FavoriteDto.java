package com.hamza.bitma.dto.model;

import com.hamza.bitma.entity.Offer;
import com.hamza.bitma.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FavoriteDto {

    private Long id;
    private User user;
    private Offer offer;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdate;

}
