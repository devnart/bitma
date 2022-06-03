package com.hamza.bitma.dto.model;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdate;
}
