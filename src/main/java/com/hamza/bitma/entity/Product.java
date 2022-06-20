package com.hamza.bitma.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    private String type;
    private String city;
    private Double price;
    private boolean availability;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime available_from;
    private LocalDateTime created_date;

}
