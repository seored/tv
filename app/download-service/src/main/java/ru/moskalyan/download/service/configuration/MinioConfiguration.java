package ru.moskalyan.download.service.configuration;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.moskalyan.download.service.minio.MinioProperties;

@Configuration
@ComponentScan("ru.moskalyan.download.service.minio")
public class MinioConfiguration {

    @Bean
    public MinioClient minioClient(MinioProperties properties) throws InvalidPortException, InvalidEndpointException {
        return new MinioClient(properties.getEndpoint(), properties.getAccessKey(), properties.getSecretKey());
    }
}
