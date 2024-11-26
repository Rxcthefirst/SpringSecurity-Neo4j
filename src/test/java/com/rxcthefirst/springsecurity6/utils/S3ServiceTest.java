package com.rxcthefirst.springsecurity6.utils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;

public class S3ServiceTest {

    @Mock
    private AmazonS3 amazonS3;

    @InjectMocks
    private S3Service s3Service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetObjectFromS3() throws Exception {
        // Arrange
        String bucketName = "images-rxc";
        String objectKey = "test.txt";
        byte[] expectedContent = "Test content from S3".getBytes();

        S3Object s3Object = new S3Object();
        InputStream inputStream = new ByteArrayInputStream(expectedContent);
        s3Object.setObjectContent(inputStream);

        // Mock AmazonS3 getObject method
        when(amazonS3.getObject(new GetObjectRequest(bucketName, objectKey))).thenReturn(s3Object);

        // Act
        byte[] actualContent = s3Service.getObjectFromS3(bucketName, objectKey);

        // Assert
        assertArrayEquals(expectedContent, actualContent);
    }
}