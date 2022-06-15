package com.hamza.bitma.repository;

import com.hamza.bitma.entity.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    @Override
    Page<Offer> findAll(Pageable pageable);

    List<Offer> findAllByUserId(Long id);
}
