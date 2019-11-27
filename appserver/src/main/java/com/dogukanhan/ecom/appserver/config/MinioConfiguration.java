package com.dogukanhan.ecom.appserver.config;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfiguration {

    @Value("${minio.url}")
    private String url;

    @Value("${minio.secret_key}")
    private String secretKey;

    @Value("${minio.access_key}")
    private String accessKey;

    @Bean
    public MinioClient minioClient() throws InvalidPortException, InvalidEndpointException {
        return new MinioClient(url, accessKey, secretKey);
    }

}
