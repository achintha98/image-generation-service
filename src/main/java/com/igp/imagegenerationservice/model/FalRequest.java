package com.igp.imagegenerationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 7/17/2025
 */

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FalRequest {

    @Id
    private UUID requestId;

    private String status;

    private String modelName;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}
