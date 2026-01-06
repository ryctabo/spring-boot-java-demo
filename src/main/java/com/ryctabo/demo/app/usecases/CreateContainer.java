package com.ryctabo.demo.app.usecases;

import com.ryctabo.demo.domain.IdGenerator;
import com.ryctabo.demo.domain.container.Container;
import com.ryctabo.demo.domain.container.ContainerAlreadyExistsException;
import com.ryctabo.demo.domain.container.ContainerRepository;
import com.ryctabo.demo.domain.container.valueobjects.ContainerName;
import com.ryctabo.demo.domain.core.Country;
import com.ryctabo.demo.domain.location.LocationName;
import lombok.AllArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
public class CreateContainer {

    private final ContainerRepository repository;
    private final IdGenerator idGenerator;

    public Container invoke(ContainerName name, LocationName locationName, Country country) {
        if (this.repository.exists(name)) {
            throw new ContainerAlreadyExistsException(name);
        }
        var container = Container.createByName(this.idGenerator.containerId(), name, locationName, country, Instant.now());
        return this.repository.save(container);
    }
}
