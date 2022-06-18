package com.hamza.bitma.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hamza.bitma.entity.User;
import lombok.Data;

@Data
public class UserInfoDto {
    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String city;
    private String avatar;
}
