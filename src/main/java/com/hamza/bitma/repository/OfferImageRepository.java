package com.hamza.bitma.repository;

import com.hamza.bitma.entity.OfferImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface OfferImageRepository extends JpaRepository<OfferImage,Long> {
    List<OfferImage> findAllByOfferId(Long offerId);
}
