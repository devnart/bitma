package com.hamza.bitma.repository;

import com.hamza.bitma.entity.OfferImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
@Repository
public interface OfferImageRepository extends JpaRepository<OfferImage,Long> {
    List<OfferImage> findAllByOfferId(Long offerId);
}
