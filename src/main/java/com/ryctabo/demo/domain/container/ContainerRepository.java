package com.ryctabo.demo.domain.container;

import com.ryctabo.demo.domain.container.valueobjects.ContainerId;
import com.ryctabo.demo.domain.container.valueobjects.ContainerName;
import java.util.Optional;

public interface ContainerRepository {
    Optional<Container> findById(ContainerId id);
    Container findByIdOrThrow(ContainerId id);
    Optional<Container> findByName(ContainerName name);
    Container findByNameOrThrow(ContainerName name);
    Container save(Container container);
    boolean exists(ContainerName name);
}
