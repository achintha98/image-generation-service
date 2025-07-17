package com.igp.imagegenerationservice.service;

import ai.fal.client.*;
import ai.fal.client.queue.*;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * @author Achintha Kalunayaka
 * @since 5/19/2025
 */

@Service
public class FalAIModelService implements BaseModelService{

    @Value("${fal-ai.webhook-url}")
    private String falWebhookUrl;

    public FalAIModelService() {
        super();
    }

    @Override
    public void generateImage(String prompt, String tensorPath) {

        var fal = FalClient.withEnvCredentials();

        var input = Map.of(
                "prompt", "Extreme close-up of a single tiger eye, direct frontal view. Detailed iris and pupil. Sharp focus on eye texture and color. Natural lighting to capture authentic eye shine and depth. The word \"FLUX\" is painted over it in big, white brush strokes with visible texture."
        );
        var job = fal.queue().submit("fal-ai/flux/dev",
                QueueSubmitOptions.<JsonObject>builder()
                        .input(input)
                        .webhookUrl(falWebhookUrl)
                        .build()
        );

        var result = fal.queue().result("fal-ai/flux-lora", QueueResultOptions
                .withRequestId("764cabcf-b745-4b3e-ae38-1200304cf45b"));

    }

    @Override
    public void trainModel(String zipURL, String triggerWord) {
        var fal = FalClient.withEnvCredentials();

        var input = Map.of(
                "images_data_url", zipURL
        );
        var job = fal.queue().submit("fal-ai/flux-lora-fast-training",
                QueueSubmitOptions.<JsonObject>builder()
                        .input(input)
                        .webhookUrl(falWebhookUrl)
                        .build()
        );


    }
}
