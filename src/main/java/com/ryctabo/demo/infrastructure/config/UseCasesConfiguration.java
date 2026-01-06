package com.ryctabo.demo.infrastructure.config;

import com.ryctabo.demo.app.usecases.CreateContainer;
import com.ryctabo.demo.domain.IdGenerator;
import com.ryctabo.demo.domain.container.ContainerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfiguration {

    @Bean
    public CreateContainer createContainer(ContainerRepository repository, IdGenerator idGenerator) {
        return new CreateContainer(repository, idGenerator);
    }
}
