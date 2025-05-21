package com.igp.imagegenerationservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/15/2025
 */

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutputImage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
    private Model model;

    private String userId;

    private String prompt;

    private String aiRequestId;

    private LocalDate createAt;

    private LocalDate updateAt;
}
