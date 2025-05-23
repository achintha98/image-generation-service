package com.igp.imagegenerationservice.mapper;

import com.igp.imagegenerationservice.dto.ModelRequestDTO;
import com.igp.imagegenerationservice.dto.ModelResponseDTO;
import com.igp.imagegenerationservice.model.Model;

import java.time.LocalDate;

/**
 * @author Achintha Kalunayaka
 * @since 5/16/2025
 */
public class ModelMapper {
    public static ModelResponseDTO mapToModelResponseDTO(Model model) {
        return ModelResponseDTO.builder().
                id(model.getId().toString()).name(model.getName()).
                age(model.getAge()).gender(model.getGender()).
                ethnicity(model.getEthnicity()).eyeColor(model.getEyeColor()).build();
    }

    public static Model mapFromModelRequestDTO(ModelRequestDTO modelRequestDTO) {
        return Model.builder().name(modelRequestDTO.getName()).
                eyeColor(modelRequestDTO.getEyeColor()).isBald(modelRequestDTO.isBald()).gender(modelRequestDTO.getGender()).build();    }
}
