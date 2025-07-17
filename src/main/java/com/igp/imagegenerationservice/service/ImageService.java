package com.igp.imagegenerationservice.service;

import ai.fal.client.Output;
import com.google.gson.JsonObject;
import com.igp.imagegenerationservice.dto.OutputImageRequestDTO;
import com.igp.imagegenerationservice.dto.OutputImageResponseDTO;
import com.igp.imagegenerationservice.mapper.OutputImageMapper;
import com.igp.imagegenerationservice.model.FalRequest;
import com.igp.imagegenerationservice.model.Model;
import com.igp.imagegenerationservice.model.OutputImage;
import com.igp.imagegenerationservice.repository.FalModelRepository;
import com.igp.imagegenerationservice.repository.ImageGenerateRepository;
import com.igp.imagegenerationservice.repository.ModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/20/2025
 */

@Service
public class ImageService {

    private ModelRepository modelRepository;

    private FalModelRepository falModelRepository;

    private ImageGenerateRepository imageGenerateRepository;

    private FalAIModelService falAIModelService;

    public ImageService(ModelRepository modelRepository, ImageGenerateRepository imageGenerateRepository,
                        FalAIModelService falAIModelService, FalModelRepository falModelRepository) {
        this.modelRepository = modelRepository;
        this.falModelRepository = falModelRepository;
        this.imageGenerateRepository = imageGenerateRepository;
        this.falAIModelService = falAIModelService;
    }

    @Transactional
    public OutputImageResponseDTO generateImage(String prompt, String selectedModel) {
        Model model = modelRepository.findById(UUID.fromString(selectedModel)).orElseThrow();
        OutputImage outputImage = imageGenerateRepository.save(OutputImageMapper.mapFromOutputImageRequestDTO(prompt, model));
        falAIModelService.generateImage(outputImage.getPrompt(), outputImage.getModel().getName());
        OutputImageResponseDTO outputImageResponseDTO = OutputImageMapper.mapToOutputImageResponseDTO(outputImage);
        return outputImageResponseDTO;
    }

    public OutputImageResponseDTO updateImage(Output<JsonObject> objectOutput) {
        OutputImage outputImage = imageGenerateRepository.findByAiRequestId(objectOutput.getRequestId());
        return OutputImageMapper.mapToOutputImageResponseDTO(outputImage);
    }

    @Scheduled(fixedDelay = 30000) // every 30s
    public void pollPendingJobs() {
        List<FalRequest> pendingJobs = falModelRepository.findFalRequestByStatus("IN_QUEUE");

        if (pendingJobs.isEmpty()) {
            // No work to do — skip polling
            return;
        }

        for (FalRequest job : pendingJobs) {
            String jobStatus = falAIModelService.checkStatus(job.getRequestId().toString(), job.getModelName());

            if (jobStatus.equals("COMPLETED")) {
                Object obj = falAIModelService.returnResults(job.getRequestId().toString(), job.getModelName());
                String test = "";
            }
        }
    }

}
