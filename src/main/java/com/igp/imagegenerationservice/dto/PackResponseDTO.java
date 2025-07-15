package com.igp.imagegenerationservice.dto;

import com.igp.imagegenerationservice.model.PackPrompt;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/20/2025
 */

@Data
@Builder
public class PackResponseDTO {
    private UUID id;

    private String name;

    private String description;

    private String imageURL;

    private List<PackPrompt> packPromptList;
}
