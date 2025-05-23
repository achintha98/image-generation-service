package com.igp.imagegenerationservice.controller;

import com.igp.imagegenerationservice.dto.ModelRequestDTO;
import com.igp.imagegenerationservice.dto.ModelResponseDTO;
import com.igp.imagegenerationservice.dto.OutputImageRequestDTO;
import com.igp.imagegenerationservice.dto.OutputImageResponseDTO;
import com.igp.imagegenerationservice.service.CloudService;
import com.igp.imagegenerationservice.service.ImageGenerateService;
import com.igp.imagegenerationservice.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Achintha Kalunayaka
 * @since 5/15/2025
 */

@RestController
@RequestMapping(path = "/")
public class ModelController {

    private final ModelService modelService;

    private final CloudService cloudService;
    private final ImageGenerateService imageGenerateService;

    public ModelController(ModelService modelService, ImageGenerateService imageGenerateService, CloudService cloudService) {
        this.imageGenerateService = imageGenerateService;
        this.modelService = modelService;
        this.cloudService = cloudService;
    }

    @PostMapping (path = "ai/training")
    public ResponseEntity<ModelResponseDTO> createModel(@Validated @RequestBody ModelRequestDTO modelRequestDTO) {
        ModelResponseDTO modelResponseDTO = modelService.createModel(modelRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelResponseDTO);
    }

    @PostMapping (path = "ai/generate")
    public ResponseEntity<OutputImageResponseDTO> generateImage(@Validated @RequestBody OutputImageRequestDTO outputImageRequestDTO) {
        OutputImageResponseDTO outputImageResponseDTO = imageGenerateService.generateImage(outputImageRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(outputImageResponseDTO);
    }

    @PutMapping (path = "ai/presign-url")
    public ResponseEntity<String> getPreSignURL() {
        String preSignUrl = cloudService.createPreSignUrl();
        return ResponseEntity.status(HttpStatus.OK).body(preSignUrl);
    }
}
