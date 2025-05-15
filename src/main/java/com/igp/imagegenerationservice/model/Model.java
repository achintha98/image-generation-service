package com.igp.imagegenerationservice.model;

import com.igp.imagegenerationservice.model.enums.EyeColor;
import com.igp.imagegenerationservice.model.enums.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/15/2025
 */

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private EyeColor eyeColor;

    private boolean isBald;

    @OneToMany(mappedBy = "model")
    private List<OutputImage> outputImageList;

    @OneToMany(mappedBy = "model")
    private List<TrainingImage> trainingImageList;


}
