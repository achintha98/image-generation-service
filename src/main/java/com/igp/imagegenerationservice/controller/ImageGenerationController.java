package com.igp.imagegenerationservice.controller;

import com.igp.imagegenerationservice.dto.ImageResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Achintha Kalunayaka
 * @since 5/15/2025
 */

@RestController
@RequestMapping(path = "/")
public class ImageGenerationController {

    @GetMapping
    public ResponseEntity<ImageResponseDTO> getImages() {
        String msg = "Hello World";
        ImageResponseDTO imageResponseDTO = new ImageResponseDTO();
        imageResponseDTO.setResponseMessage(msg);
        return ResponseEntity.ok().body(imageResponseDTO);
    }
}
