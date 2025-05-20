package com.igp.imagegenerationservice.service;

import com.igp.imagegenerationservice.dto.ModelRequestDTO;
import com.igp.imagegenerationservice.dto.ModelResponseDTO;
import com.igp.imagegenerationservice.dto.OutputImageRequestDTO;
import com.igp.imagegenerationservice.dto.OutputImageResponseDTO;
import com.igp.imagegenerationservice.exception.PackNotFoundException;
import com.igp.imagegenerationservice.mapper.ModelMapper;
import com.igp.imagegenerationservice.mapper.OutputImageMapper;
import com.igp.imagegenerationservice.model.Model;
import com.igp.imagegenerationservice.model.OutputImage;
import com.igp.imagegenerationservice.model.Pack;
import com.igp.imagegenerationservice.model.PackPrompt;
import com.igp.imagegenerationservice.repository.ImageGenerateRepository;
import com.igp.imagegenerationservice.repository.PackPromptRepository;
import com.igp.imagegenerationservice.repository.PackRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Achintha Kalunayaka
 * @since 5/20/2025
 */

@Service
public class PackService {

    private final PackRepository packRepository;
    private final PackPromptRepository packPromptRepository;
    private final ImageGenerateRepository imageGenerateRepository;

    public PackService(PackRepository packRepository, PackPromptRepository packPromptRepository, ImageGenerateRepository imageGenerateRepository) {
        this.packRepository = packRepository;
        this.packPromptRepository = packPromptRepository;
        this.imageGenerateRepository = imageGenerateRepository;
    }

    public List<OutputImageResponseDTO> generatePack(UUID packId, Model model) {
        Pack existingPack = packRepository.findById(packId)
                .orElseThrow(() -> new PackNotFoundException("A Pack with given packId does not exist: " + packId));
        List<OutputImageResponseDTO> outputImageResponseDTOList =
                existingPack.getPackPromptList().stream()
                        .map(packPrompt -> {
                            OutputImageRequestDTO dto = OutputImageRequestDTO.builder()
                                    .imageURL("")
                                    .prompt(packPrompt.getPrompts())
                                    .model(model)
                                    .build();

                            OutputImage outputImage = imageGenerateRepository.save(
                                    OutputImageMapper.mapFromOutputImageRequestDTO(dto)
                            );

                            return OutputImageMapper.mapToOutputImageResponseDTO(outputImage); // returns 1 DTO
                        }).toList();
        return outputImageResponseDTOList;
    }
}
