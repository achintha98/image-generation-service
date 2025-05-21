package com.igp.imagegenerationservice.service;

import ai.fal.client.*;
import ai.fal.client.queue.*;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;


/**
 * @author Achintha Kalunayaka
 * @since 5/19/2025
 */
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
        var job = fal.queue().submit("fal-ai/flux-lora",
                QueueSubmitOptions.<JsonObject>builder()
                        .input(input)
                        .webhookUrl(falWebhookUrl)
                        .build()
        );


    }

    @Override
    public void trainImage(String zipURL, String triggerWord) {
        var fal = FalClient.withEnvCredentials();

        var input = Map.of(
                "images_data_url", ""
        );
        var job = fal.queue().submit("fal-ai/flux-lora-fast-training",
                QueueSubmitOptions.<JsonObject>builder()
                        .input(input)
                        .webhookUrl(falWebhookUrl)
                        .build()
        );


    }
}
