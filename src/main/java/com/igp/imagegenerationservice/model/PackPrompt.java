package com.igp.imagegenerationservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/15/2025
 */

@Entity
@Data
public class PackPrompt {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private String prompts;

    @ManyToOne
    @JoinColumn(name = "pack_id", referencedColumnName = "id", nullable = false)
    private Pack pack;

}
