package com.igp.imagegenerationservice.repository;

import com.igp.imagegenerationservice.model.PackPrompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/20/2025
 */
@Repository
public interface PackPromptRepository extends JpaRepository<PackPrompt, UUID> {

}
