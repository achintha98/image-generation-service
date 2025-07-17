package com.igp.imagegenerationservice.controller;

import com.igp.imagegenerationservice.dto.*;
import com.igp.imagegenerationservice.service.CloudService;
import com.igp.imagegenerationservice.service.ImageService;
import com.igp.imagegenerationservice.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    private final ImageService imageService;
    public ModelController(ModelService modelService, ImageService imageService, CloudService cloudService) {
        this.imageService = imageService;
        this.modelService = modelService;
        this.cloudService = cloudService;
    }
    @PostMapping (path = "ai/training")
    public ResponseEntity<ModelResponseDTO> createModel(@Validated @RequestBody ModelRequestDTO modelRequestDTO) {
//        String clerkUserId = jwt.getSubject();
//        modelRequestDTO.setUserId(clerkUserId);
        ModelResponseDTO modelResponseDTO = modelService.createModel(modelRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelResponseDTO);
    }

    @PostMapping (path = "ai/public/training")
    public ResponseEntity<ModelResponseDTO> createPublicModel(@Validated @RequestBody ModelRequestDTO modelRequestDTO) {
//        String clerkUserId = jwt.getSubject();
//        modelRequestDTO.setUserId(clerkUserId);
        ModelResponseDTO modelResponseDTO = modelService.createPublicModel(modelRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelResponseDTO);
    }

    @PostMapping (path = "ai/generate")
    public ResponseEntity<OutputImageResponseDTO> generateImage(@RequestBody Map<String, String> payload) {
        OutputImageResponseDTO outputImageResponseDTO = imageService.generateImage(payload.get("prompt"), payload.get("selectedModel"));
        return ResponseEntity.status(HttpStatus.CREATED).body(outputImageResponseDTO);
    }
    @GetMapping (path = "ai/presign-url")
    public ResponseEntity<PreSignResponseDTO> getPreSignURL() {
        PreSignResponseDTO preSignResponse = cloudService.createPreSignUrl();
        return ResponseEntity.status(HttpStatus.OK).body(preSignResponse);
    }
    @GetMapping (path = "ai/models")
    public ResponseEntity<List<ModelResponseDTO>> getModelList() {
        List<ModelResponseDTO> modelList = modelService.getModelList();
        return ResponseEntity.status(HttpStatus.OK).body(modelList);
    }
}
