package com.igp.imagegenerationservice.controller;

import com.igp.imagegenerationservice.dto.OutputImageResponseDTO;
import com.igp.imagegenerationservice.dto.PackResponseDTO;
import com.igp.imagegenerationservice.model.Model;
import com.igp.imagegenerationservice.service.PackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/20/2025
 */

@RestController
@RequestMapping(path = "/pack")
public class PackController {

    private final PackService packService;

    public PackController(PackService packService) {
        this.packService = packService;
    }

    @PostMapping(path = "/generate/{packId}")
    public ResponseEntity<List<OutputImageResponseDTO>> generatePackImages(@PathVariable UUID packId, @RequestBody Model model) {
        List<OutputImageResponseDTO> outputImageResponseDTO = packService.generatePack(packId, model);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(outputImageResponseDTO);
    }

    //TODO: need to lazy load PackPrompt list in packs and need to add pagination in here instead of loading everything by findAll()
    @GetMapping(path = "/pack/bulk")
    public ResponseEntity<List<PackResponseDTO>> getAllPacks() {
        List<PackResponseDTO> packResponseDTO = packService.retrieveAllPacks();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(packResponseDTO);
    }
}
