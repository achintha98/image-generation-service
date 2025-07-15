package com.igp.imagegenerationservice.mapper;

import com.igp.imagegenerationservice.dto.OutputImageResponseDTO;
import com.igp.imagegenerationservice.dto.PackResponseDTO;
import com.igp.imagegenerationservice.model.OutputImage;
import com.igp.imagegenerationservice.model.Pack;

/**
 * @author Achintha Kalunayaka
 * @since 5/20/2025
 */
public class PackMapper {
    public static PackResponseDTO mapToPackResponseDTO(Pack pack) {
        return PackResponseDTO.builder().id(pack.getId()).name(pack.getName()).
                description(pack.getDescription()).imageURL(pack.getImageURL()).build();
    }

}
