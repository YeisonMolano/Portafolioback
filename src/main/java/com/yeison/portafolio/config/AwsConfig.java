package com.yeison.portafolio.config;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {
    @Value("${amazon.access-key}")
    private String awsAccessKeyId;

    @Value("${amazon.secret-key}")
    private String awsSecretKey;

    @Bean
    public AmazonSimpleEmailServiceClient sesClient() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretKey);
        return new AmazonSimpleEmailServiceClient(awsCredentials);
    }
}
