package com.example.Mafia_Match.util;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Minio {

    public MinioClient minioClient;

    public Minio() {

        try {
            minioClient = MinioClient.builder().endpoint("http://localhost:9000/").credentials("minio", "rootroot").build();

            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket("mafia_match").build());

            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("mafia_match").build());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
