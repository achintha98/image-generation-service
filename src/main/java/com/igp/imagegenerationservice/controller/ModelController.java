package com.igp.imagegenerationservice.controller;

import com.igp.imagegenerationservice.dto.ImageRequestDTO;
import com.igp.imagegenerationservice.dto.ImageResponseDTO;
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

    @PostMapping (path = "ai/training")
    public ResponseEntity<ImageResponseDTO> createModel(@Validated @RequestBody ImageRequestDTO imageRequestDTO) {
        String msg = "Hello World";
        ImageResponseDTO imageResponseDTO = new ImageResponseDTO();
        imageResponseDTO.setResponseMessage(msg);
        return ResponseEntity.ok().body(imageResponseDTO);
    }
}
