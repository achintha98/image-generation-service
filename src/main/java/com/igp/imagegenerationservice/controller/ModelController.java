package com.igp.imagegenerationservice.controller;

import com.igp.imagegenerationservice.dto.*;
import com.igp.imagegenerationservice.service.CloudService;
import com.igp.imagegenerationservice.service.ImageGenerateService;
import com.igp.imagegenerationservice.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;

/**
 * @author Achintha Kalunayaka
 * @since 5/15/2025
 */

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
    public ResponseEntity<ModelResponseDTO> createModel(@Validated @AuthenticationPrincipal Jwt jwt, @RequestBody ModelRequestDTO modelRequestDTO) {
        String clerkUserId = jwt.getSubject();
        modelRequestDTO.setUserId(clerkUserId);
        ModelResponseDTO modelResponseDTO = modelService.createModel(modelRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelResponseDTO);
    }

    @PostMapping (path = "ai/generate")
    public ResponseEntity<OutputImageResponseDTO> generateImage(@Validated @RequestBody OutputImageRequestDTO outputImageRequestDTO) {
        OutputImageResponseDTO outputImageResponseDTO = imageGenerateService.generateImage(outputImageRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(outputImageResponseDTO);
    }

    @GetMapping (path = "ai/presign-url")
    public ResponseEntity<PreSignResponseDTO> getPreSignURL() {
        PreSignResponseDTO preSignResponse = cloudService.createPreSignUrl();
        return ResponseEntity.status(HttpStatus.OK).body(preSignResponse);
    }
}
