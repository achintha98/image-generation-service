package com.igp.imagegenerationservice.repository;

import com.igp.imagegenerationservice.model.FalRequest;
import com.igp.imagegenerationservice.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Achintha Kalunayaka
 * @since 7/17/2025
 */

@Repository
public interface FalModelRepository extends JpaRepository<FalRequest, Integer> {
    List<FalRequest> findFalRequestByStatus(String status);
}
