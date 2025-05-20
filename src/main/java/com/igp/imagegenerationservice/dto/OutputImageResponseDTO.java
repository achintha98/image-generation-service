package com.igp.imagegenerationservice.dto;

import com.igp.imagegenerationservice.model.Model;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/20/2025
 */

@Data
@Builder
public class OutputImageResponseDTO {

    private String id;

    private String imageURL;

    private Model model;

    private String userId;

    private String prompt;

    private LocalDate createAt;

    private LocalDate updateAt;
}
