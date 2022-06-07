package com.hamza.bitma.entity;

import com.hamza.bitma.enumeration.RoomType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    private String title;
    private String description;
    private String city;
    private String address;
    private Double price;
    private int places;
    private int rooms;
    private RoomType roomType;

    @Nullable
    private Boolean availability;

    @Nullable
    private LocalDate availableFrom;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
