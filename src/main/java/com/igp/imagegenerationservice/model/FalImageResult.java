package com.igp.imagegenerationservice.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * @author Achintha Kalunayaka
 * @since 7/18/2025
 */
@Data
public class FalImageResult {
    private List<Image> images;
    private Timings timings;
    private long seed;

    @SerializedName("has_nsfw_concepts")
    private List<Boolean> hasNsfwConcepts;

    private String prompt;

    @Data
    public static class Image {
        private String url;
        private int width;
        private int height;

        @SerializedName("content_type")
        private String contentType;
    }

    @Data
    public static class Timings {
        private double inference;
    }
}
