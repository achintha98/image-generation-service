package com.igp.imagegenerationservice.model;

import com.igp.imagegenerationservice.model.enums.EyeColor;
import com.igp.imagegenerationservice.model.enums.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/15/2025
 */

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private int age;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String userId;

    private String ethnicity;

    @Enumerated(EnumType.STRING)
    private EyeColor eyeColor;

    private boolean isBald;

    @OneToMany(mappedBy = "model")
    private List<OutputImage> outputImageList;

    @OneToMany(mappedBy = "model")
    private List<TrainingImage> trainingImageList;


}
