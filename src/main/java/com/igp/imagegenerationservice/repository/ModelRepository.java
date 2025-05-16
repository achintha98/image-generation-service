package com.igp.imagegenerationservice.repository;

import com.igp.imagegenerationservice.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/16/2025
 */
public interface ModelRepository extends JpaRepository<Model, UUID> {
}
