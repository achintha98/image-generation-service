package com.igp.imagegenerationservice.controller;

import ai.fal.client.Output;
import com.google.gson.JsonObject;
import com.igp.imagegenerationservice.dto.ModelResponseDTO;
import com.igp.imagegenerationservice.dto.OutputImageResponseDTO;
import com.igp.imagegenerationservice.service.ImageService;
import com.igp.imagegenerationservice.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Achintha Kalunayaka
 * @since 5/21/2025
 */
@RestController
@RequestMapping(path = "/")
public class WebhookController {

    private final ModelService modelService;
    private final ImageService imageService;

    public  WebhookController(ModelService modelService, ImageService imageService) {
        this.imageService = imageService;
        this.modelService = modelService;
    }

    @PostMapping(path = "fal-ai/webhook/training")
    public ResponseEntity<ModelResponseDTO> trainModel(@RequestBody Map<String, Object> payload) {
        String status = (String) payload.get("status");
        Map<String, Object> nested = (Map<String, Object>) payload.get("payload");
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "fal-ai/webhook/generate")
    public ResponseEntity<OutputImageResponseDTO> generateImage( @RequestBody Map<String, Object> payload) {
        String status = (String) payload.get("status");
        Map<String, Object> nested = (Map<String, Object>) payload.get("payload");
        return ResponseEntity.ok().build();
    }
}
