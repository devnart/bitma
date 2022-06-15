package com.hamza.bitma.repository;

import com.hamza.bitma.entity.Demand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Long>{
    @Override
    Page<Demand> findAll(Pageable pageable);

    List<Demand> findAllByUserId(Long userId);
}
