package com.igp.imagegenerationservice.service;

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

    public OutputImageResponseDTO createModel(OutputImageRequestDTO outputImageRequestDTO) {
        OutputImage outputImage = imageGenerateRepository.save(OutputImageMapper.mapFromOutputImageRequestDTO(outputImageRequestDTO));
        return OutputImageMapper.mapToOutputImageResponseDTO(outputImage);
    }

}
