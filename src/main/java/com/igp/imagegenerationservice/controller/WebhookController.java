package com.igp.imagegenerationservice.controller;

import ai.fal.client.Output;
import ai.fal.client.queue.QueueStatus;
import com.google.gson.JsonObject;
import com.igp.imagegenerationservice.dto.ModelRequestDTO;
import com.igp.imagegenerationservice.dto.ModelResponseDTO;
import com.igp.imagegenerationservice.dto.OutputImageResponseDTO;
import com.igp.imagegenerationservice.service.ImageGenerateService;
import com.igp.imagegenerationservice.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Achintha Kalunayaka
 * @since 5/21/2025
 */
public class WebhookController {

    private final ModelService modelService;
    private final ImageGenerateService imageGenerateService;

    public  WebhookController(ModelService modelService, ImageGenerateService imageGenerateService) {
        this.imageGenerateService = imageGenerateService;
        this.modelService = modelService;
    }

    @PostMapping(path = "fal-ai/webhook/training")
    public ResponseEntity<ModelResponseDTO> trainModel(@RequestBody Output<JsonObject> objectOutput) {
        ModelResponseDTO modelResponseDTO = modelService.updateModel(objectOutput);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelResponseDTO);
    }

    @PostMapping(path = "fal-ai/webhook/generate")
    public ResponseEntity<OutputImageResponseDTO> generateImage( @RequestBody Output<JsonObject> objectOutput) {
        OutputImageResponseDTO outputImageResponseDTO = imageGenerateService.updateImage(objectOutput);
        return ResponseEntity.status(HttpStatus.CREATED).body(outputImageResponseDTO);
    }
}
