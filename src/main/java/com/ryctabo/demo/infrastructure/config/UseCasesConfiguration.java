package com.ryctabo.demo.infrastructure.config;

import com.ryctabo.demo.app.usecases.container.CreateContainerService;
import com.ryctabo.demo.domain.IdGenerator;
import com.ryctabo.demo.domain.container.ContainerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfiguration {

    @Bean
    public CreateContainerService createContainer(ContainerRepository repository, IdGenerator idGenerator) {
        return new CreateContainerService(repository, idGenerator);
    }
}
