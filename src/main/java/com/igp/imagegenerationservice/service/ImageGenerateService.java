package com.igp.imagegenerationservice.service;

import ai.fal.client.Output;
import com.google.gson.JsonObject;
import com.igp.imagegenerationservice.dto.OutputImageRequestDTO;
import com.igp.imagegenerationservice.dto.OutputImageResponseDTO;
import com.igp.imagegenerationservice.mapper.OutputImageMapper;
import com.igp.imagegenerationservice.model.OutputImage;
import com.igp.imagegenerationservice.repository.ImageGenerateRepository;
import org.springframework.stereotype.Service;

/**
 * @author Achintha Kalunayaka
 * @since 5/20/2025
 */

@Service
public class ImageGenerateService {

    private ImageGenerateRepository imageGenerateRepository;

    public ImageGenerateService(ImageGenerateRepository imageGenerateRepository) {
        this.imageGenerateRepository = imageGenerateRepository;
    }

    public OutputImageResponseDTO generateImage(OutputImageRequestDTO outputImageRequestDTO) {
        OutputImage outputImage = imageGenerateRepository.save(OutputImageMapper.mapFromOutputImageRequestDTO(outputImageRequestDTO));
        return OutputImageMapper.mapToOutputImageResponseDTO(outputImage);
    }

    public OutputImageResponseDTO updateImage(Output<JsonObject> objectOutput) {
        OutputImage outputImage = imageGenerateRepository.findByAiRequestId(objectOutput.getRequestId());
        return OutputImageMapper.mapToOutputImageResponseDTO(outputImage);
    }
}
