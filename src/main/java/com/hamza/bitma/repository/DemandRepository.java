package com.hamza.bitma.repository;

import com.hamza.bitma.entity.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Long>{
    List<Demand> findAllByUserId(Long userId);
}
