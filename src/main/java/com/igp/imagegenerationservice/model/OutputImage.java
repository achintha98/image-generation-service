package com.igp.imagegenerationservice.model;

import jakarta.persistence.*;

import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/15/2025
 */

@Entity
public class OutputImage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
    private Model model;
}
