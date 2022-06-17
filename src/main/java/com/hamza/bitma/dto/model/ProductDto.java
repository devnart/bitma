package com.hamza.bitma.dto.model;

import com.hamza.bitma.entity.User;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Data
public class ProductDto {
    private long id;
    private User userId;
    private String city;
    private Double price;
    private boolean availability;
    private Date available_from;
    private Date created_date;
}
