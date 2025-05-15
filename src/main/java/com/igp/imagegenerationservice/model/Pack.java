package com.igp.imagegenerationservice.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/15/2025
 */

@Entity
public class Pack {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "pack")
    private List<PackPrompt> packPromptList;
}
