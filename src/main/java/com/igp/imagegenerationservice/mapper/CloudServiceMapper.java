package com.igp.imagegenerationservice.mapper;

import com.igp.imagegenerationservice.dto.ModelResponseDTO;
import com.igp.imagegenerationservice.dto.PreSignResponseDTO;
import com.igp.imagegenerationservice.model.Model;

/**
 * @author Achintha Kalunayaka
 * @since 5/24/2025
 */
public class CloudServiceMapper {
    public static PreSignResponseDTO mapToPreSignURLResponseDTO(String key, String preSignURL) {
        return PreSignResponseDTO.builder().
                key(key).responseURL(preSignURL).build();
    }
}
