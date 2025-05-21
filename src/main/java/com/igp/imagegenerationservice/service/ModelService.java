package com.igp.imagegenerationservice.service;

import com.igp.imagegenerationservice.dto.ModelRequestDTO;
import com.igp.imagegenerationservice.dto.ModelResponseDTO;
import com.igp.imagegenerationservice.mapper.ModelMapper;
import com.igp.imagegenerationservice.model.Model;
import com.igp.imagegenerationservice.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Achintha Kalunayaka
 * @since 5/16/2025
 */

@Service
public class ModelService {


    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public ModelResponseDTO createModel(ModelRequestDTO modelRequestDTO) {
        Model model = modelRepository.save(ModelMapper.mapFromModelRequestDTO(modelRequestDTO));
        return ModelMapper.mapToModelResponseDTO(model);
    }
}
