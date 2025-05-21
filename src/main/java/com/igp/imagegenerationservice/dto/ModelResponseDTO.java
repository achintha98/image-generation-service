package com.igp.imagegenerationservice.dto;

import com.igp.imagegenerationservice.model.enums.EyeColor;
import com.igp.imagegenerationservice.model.enums.Ethnicity;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

/**
 * @author Achintha Kalunayaka
 * @since 5/15/2025
 */

@Data
@Builder
public class ModelResponseDTO {

    private String id;

    @NotNull
    private String name;

    private int age;

    private String ethnicity;

    private Ethnicity type;

    private EyeColor eyeColor;

    private boolean isBald;
}
