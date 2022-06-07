package com.hamza.bitma.dto.model;

import lombok.Data;

@Data
public class UserInfoDto {
    private long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String city;
    private String avatar;
}
