package com.igp.imagegenerationservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.net.URI;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Map;

/**
 * @author Achintha Kalunayaka
 * @since 5/23/2025
 */

@Service
public class CloudService {

    private static final Logger logger = LoggerFactory.getLogger(CloudService.class);


    @Value("${access-key}")
    private String accessKey;

    @Value("${secret-key}")
    private String secretKey;

    @Value("${bucket-name}")
    private String bucketName;

    @Value("${endpoint}")
    private String endpoint;

    public String createPreSignUrl() {

        try {
            S3Presigner preSigner = S3Presigner.builder()
                    .region(Region.of("APAC"))
                    .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)))
                    .endpointOverride(URI.create(endpoint))
                    .build();

            PutObjectRequest objectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key("models"+ LocalDate.now() + Math.random() + ".zip")
                    .build();

            PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofMinutes(10))  // The URL expires in 10 minutes.
                    .putObjectRequest(objectRequest)
                    .build();

            PresignedPutObjectRequest presignedRequest = preSigner.presignPutObject(presignRequest);
            String myURL = presignedRequest.url().toString();
            logger.info("Presigned URL to upload a file to: [{}]", myURL);
            logger.info("HTTP method: [{}]", presignedRequest.httpRequest().method());

            return presignedRequest.url().toExternalForm();
        }
    catch(Exception ex) {
        logger.error(ex.getMessage());
        throw new RuntimeException();
        }
    }

}
