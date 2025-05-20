package com.igp.imagegenerationservice.repository;

import com.igp.imagegenerationservice.model.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/20/2025
 */

@Repository
public interface PackRepository extends JpaRepository<Pack, UUID> {
}
