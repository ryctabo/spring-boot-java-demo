package com.ryctabo.demo.app.usecases.container;

import com.ryctabo.demo.domain.IdGenerator;
import com.ryctabo.demo.domain.container.Container;
import com.ryctabo.demo.domain.container.ContainerAlreadyExistsException;
import com.ryctabo.demo.domain.container.ContainerRepository;
import java.time.Instant;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateContainerService implements CreateContainerUseCase {

    private final ContainerRepository repository;
    private final IdGenerator idGenerator;

    @Override
    public Container invoke(CreateContainerCommand command) {
        if (this.repository.exists(command.name())) {
            throw new ContainerAlreadyExistsException(command.name());
        }

        var container = Container.createByName(
                this.idGenerator.containerId(),
                command.name(),
                command.locationName(),
                command.country(),
                Instant.now());

        return this.repository.save(container);
    }
}
