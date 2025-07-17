package com.igp.imagegenerationservice.service;

import ai.fal.client.*;
import ai.fal.client.queue.*;

import com.google.gson.JsonObject;
import com.igp.imagegenerationservice.model.FalRequest;
import com.igp.imagegenerationservice.repository.FalModelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;


/**
 * @author Achintha Kalunayaka
 * @since 5/19/2025
 */

@Service
public class FalAIModelService implements BaseModelService{

    private static final Logger logger = LoggerFactory.getLogger(FalAIModelService.class);

    @Value("${fal-ai.webhook-url}")
    private String falWebhookUrl;

    private FalModelRepository falModelRepository;

    public FalAIModelService(FalModelRepository falModelRepository) {
        this.falModelRepository = falModelRepository;
    }

    @Override
    public void generateImage(String prompt, String tensorPath) {
        try {
            var fal = FalClient.withEnvCredentials();

            var input = Map.of(
                    "prompt", prompt
            );
            var job = fal.queue().submit(tensorPath,
                    QueueSubmitOptions.<JsonObject>builder()
                            .input(input)
                            .webhookUrl(falWebhookUrl + "fal-ai/webhook/generate")
                            .build()
            );
            FalRequest falRequest = FalRequest.builder().requestId(UUID.fromString(job.getRequestId())).
                    status("IN_QUEUE").modelName(tensorPath).build();
            falModelRepository.save(falRequest);
        }
        catch (RuntimeException runtimeException) {
            logger.error("Error connecting to fal.ai: {}", runtimeException.getMessage());
        }
    }

    @Override
    public Integer trainModel(String zipURL, String triggerWord) {
        var fal = FalClient.withEnvCredentials();

        var input = Map.of(
                "images_data_url", zipURL
        );
        return fal.queue().submit("fal-ai/flux-lora-fast-training",
                QueueSubmitOptions.<JsonObject>builder()
                        .input(input)
                        .webhookUrl(falWebhookUrl)
                        .build()
        ).getQueuePosition();
    }

    public String checkStatus(String requestId, String tensorPath) {
        var fal = FalClient.withEnvCredentials();

        return fal.queue().status(tensorPath, QueueStatusOptions
                .withRequestId(requestId)).getStatus().toString();

    }

    public Map<String, ?> returnResults(String requestId, String tensorPath) {
        var fal = FalClient.withEnvCredentials();

        return fal.queue().result(tensorPath, QueueResultOptions
                .withRequestId(requestId)).getData().asMap();

    }
}
