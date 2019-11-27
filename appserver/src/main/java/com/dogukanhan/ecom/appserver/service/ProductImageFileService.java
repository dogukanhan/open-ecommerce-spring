package com.dogukanhan.ecom.appserver.service;

import io.minio.ErrorCode;
import io.minio.MinioClient;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductImageFileService {

    @Value("${minio.buckets.product_image}")
    private String bucket;

    private Set<String> permittedTypes = Set.of(".png", ".jpg", ".jpeg", ".gif");

    private final MinioClient minioClient;

    public String upload(MultipartFile file) throws IOException, XmlPullParserException, NoSuchAlgorithmException, InvalidKeyException, InvalidArgumentException, InvalidResponseException, InternalException, NoResponseException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException {

        final String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        if (!permittedTypes.contains(extension)) {
            throw new IllegalArgumentException("File extension is not permitted");
        }

        String fileName = UUID.randomUUID().toString() + extension;

        try {
            minioClient.getObject(bucket, fileName);
            while (true) {
                fileName = UUID.randomUUID().toString() + extension;
                minioClient.getObject(bucket, fileName);
            }
        } catch (ErrorResponseException e) {
            ErrorCode code = e.errorResponse().errorCode();
            if (code == ErrorCode.NO_SUCH_KEY || code == ErrorCode.NO_SUCH_OBJECT) {

                minioClient.putObject(bucket, fileName, file.getInputStream(), file.getSize(), null, null, null);
                return fileName;

            } else {
                throw e;
            }
        }
    }

    public void remove(@NotNull String fileName) throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InvalidArgumentException, InvalidResponseException, InternalException, NoResponseException, InvalidBucketNameException, XmlPullParserException, ErrorResponseException {
        minioClient.removeObject(bucket, fileName);
    }
}
