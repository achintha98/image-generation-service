package com.igp.imagegenerationservice.mapper;

import com.igp.imagegenerationservice.dto.OutputImageRequestDTO;
import com.igp.imagegenerationservice.dto.OutputImageResponseDTO;
import com.igp.imagegenerationservice.model.Model;
import com.igp.imagegenerationservice.model.OutputImage;

/**
 * @author Achintha Kalunayaka
 * @since 5/20/2025
 */
public class OutputImageMapper {

    public static OutputImageResponseDTO mapToOutputImageResponseDTO(OutputImage outputImage) {
        return OutputImageResponseDTO.builder().
                id(outputImage.getId().toString()).prompt(outputImage.getPrompt()).
                model(outputImage.getModel()).imageURL(outputImage.getImageURL()).build();
    }

    public static OutputImage mapFromOutputImageRequestDTO(String prompt, Model model) {
        return OutputImage.builder().prompt(prompt).
                model(model).build();
    }
}

