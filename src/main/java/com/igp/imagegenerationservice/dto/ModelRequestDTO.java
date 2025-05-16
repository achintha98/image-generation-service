package com.igp.imagegenerationservice.dto;

import com.igp.imagegenerationservice.model.OutputImage;
import com.igp.imagegenerationservice.model.TrainingImage;
import com.igp.imagegenerationservice.model.enums.EyeColor;
import com.igp.imagegenerationservice.model.enums.Type;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * @author Achintha Kalunayaka
 * @since 5/16/2025
 */
@Data
public class ModelRequestDTO {

    @NotNull
    private String name;

    private int age;

    private String ethnicity;

    private Type type;

    private EyeColor eyeColor;

    private boolean isBald;

    private List<OutputImage> outputImageList;

    private List<TrainingImage> trainingImageList;
}
