package com.igp.imagegenerationservice.dto;

import lombok.*;

/**
 * @author Achintha Kalunayaka
 * @since 5/15/2025
 */


public class ImageResponseDTO {

    private String responseMessage;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
