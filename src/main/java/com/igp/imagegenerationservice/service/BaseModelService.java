package com.igp.imagegenerationservice.service;

/**
 * @author Achintha Kalunayaka
 * @since 5/18/2025
 */
public interface BaseModelService {

    void generateImage(String prompt, String tensorPath);
    Integer trainModel(String zipURL, String triggerWord);

}
