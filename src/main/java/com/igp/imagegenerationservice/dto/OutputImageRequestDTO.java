package com.igp.imagegenerationservice.dto;

import com.igp.imagegenerationservice.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Achintha Kalunayaka
 * @since 5/20/2025
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OutputImageRequestDTO {

    private Model model;

    private String userId;

    private String prompt;
}
