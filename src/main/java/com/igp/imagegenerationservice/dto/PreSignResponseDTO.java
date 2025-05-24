package com.igp.imagegenerationservice.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Achintha Kalunayaka
 * @since 5/24/2025
 */

@Data
@Builder
public class PreSignResponseDTO {

    private String key;
    private String responseURL;

}
