package com.hamza.bitma.repository;

import com.hamza.bitma.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    Collection<Favorite> findByUserId(long userId);
}
