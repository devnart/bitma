package com.hamza.bitma.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(targetEntity = Offer.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "OfferId", referencedColumnName = "id")
    private User OfferId;

    private String image;
}
