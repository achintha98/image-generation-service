package com.igp.imagegenerationservice.controller;

import com.igp.imagegenerationservice.dto.ModelRequestDTO;
import com.igp.imagegenerationservice.dto.ModelResponseDTO;
import com.igp.imagegenerationservice.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Achintha Kalunayaka
 * @since 5/20/2025
 */

@RestController
@RequestMapping(path = "/")
public class ImageGenerateController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping(path = "ai/training")
    public ResponseEntity<ModelResponseDTO> createModel(@Validated @RequestBody ModelRequestDTO modelRequestDTO) {
        ModelResponseDTO modelResponseDTO = modelService.createModel(modelRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelResponseDTO);
    }

}
