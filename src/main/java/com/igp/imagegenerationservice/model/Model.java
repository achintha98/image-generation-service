package com.igp.imagegenerationservice.model;

import com.igp.imagegenerationservice.model.enums.Ethnicity;
import com.igp.imagegenerationservice.model.enums.EyeColor;
import com.igp.imagegenerationservice.model.enums.Gender;
import com.igp.imagegenerationservice.model.enums.ModelTrainingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private Gender gender;

    private String userId;

    @Enumerated(EnumType.STRING)
    private Ethnicity ethnicity;

    @Enumerated(EnumType.STRING)
    private ModelTrainingStatus trainingStatus;

    @Enumerated(EnumType.STRING)
    private EyeColor eyeColor;

    private boolean isBald;

    private String aiRequestId;

    private String zipUrl;

    private String triggerWord;

    private String tensorPath;

    private LocalDate createAt;

    private LocalDate updateAt;

    @OneToMany(mappedBy = "model")
    private List<OutputImage> outputImageList;

    @OneToMany(mappedBy = "model")
    private List<TrainingImage> trainingImageList;


}
