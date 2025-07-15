package com.igp.imagegenerationservice.service;

import ai.fal.client.Output;
import com.google.gson.JsonObject;
import com.igp.imagegenerationservice.dto.ModelRequestDTO;
import com.igp.imagegenerationservice.dto.ModelResponseDTO;
import com.igp.imagegenerationservice.mapper.ModelMapper;
import com.igp.imagegenerationservice.model.Model;
import com.igp.imagegenerationservice.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Model model = ModelMapper.mapFromModelRequestDTO(modelRequestDTO);
        modelRepository.save(model);
        return ModelMapper.mapToModelResponseDTO(model);
    }

    public ModelResponseDTO updateModel(Output<JsonObject> objectOutput) {
        Model model = modelRepository.findByAiRequestId(objectOutput.getRequestId());
        return ModelMapper.mapToModelResponseDTO(model);
    }

    public List<ModelResponseDTO> getModelList() {
        List<Model> models = modelRepository.findByIsOpenTrue();
        return models.stream().map(ModelMapper::mapToModelResponseDTO).toList();
    }

}
