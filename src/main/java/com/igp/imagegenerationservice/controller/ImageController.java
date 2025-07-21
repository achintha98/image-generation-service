package com.igp.imagegenerationservice.controller;

import com.igp.imagegenerationservice.dto.OutputImageResponseDTO;
import com.igp.imagegenerationservice.service.CloudService;
import com.igp.imagegenerationservice.service.ImageService;
import com.igp.imagegenerationservice.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Achintha Kalunayaka
 * @since 7/21/2025
 */

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(path = "ai/generate")
    public ResponseEntity<OutputImageResponseDTO> generateImage(@RequestBody Map<String, String> payload) {
        OutputImageResponseDTO outputImageResponseDTO = imageService.generateImage(payload.get("prompt"), payload.get("selectedModel"));
        return ResponseEntity.status(HttpStatus.CREATED).body(outputImageResponseDTO);
    }

    @GetMapping(path = "ai/generate")
    public ResponseEntity<List<OutputImageResponseDTO>> getImages() {
        List<OutputImageResponseDTO> outputImageResponseDTO = imageService.getImages();
        return ResponseEntity.ok(outputImageResponseDTO);
    }
}
