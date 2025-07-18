package com.igp.imagegenerationservice.dto;

import com.igp.imagegenerationservice.model.enums.EyeColor;
import com.igp.imagegenerationservice.model.enums.Ethnicity;
import com.igp.imagegenerationservice.model.enums.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

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

    private Ethnicity ethnicity;

    private Gender gender;

    private String thumbnail;

    private String zipUrl;

    private EyeColor eyeColor;

    private Boolean isOpen;

    private boolean isBald;
}
