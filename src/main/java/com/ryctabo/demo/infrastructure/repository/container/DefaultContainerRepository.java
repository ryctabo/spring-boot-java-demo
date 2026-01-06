package com.ryctabo.demo.infrastructure.repository.container;

import com.ryctabo.demo.domain.container.Container;
import com.ryctabo.demo.domain.container.ContainerNotFoundException;
import com.ryctabo.demo.domain.container.ContainerRepository;
import com.ryctabo.demo.domain.container.valueobjects.ContainerId;
import com.ryctabo.demo.domain.container.valueobjects.ContainerName;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class DefaultContainerRepository implements ContainerRepository {

    private final JpaContainerRepository repository;
    private final ContainerConverter converter;

    @Override
    public Optional<Container> findById(ContainerId id) {
        return this.repository.findById(id.toString()).map(this.converter::toDomain);
    }

    @Override
    public Container findByIdOrThrow(ContainerId id) {
        return this.findById(id).orElseThrow(() -> new ContainerNotFoundException(id));
    }

    @Override
    public Optional<Container> findByName(ContainerName name) {
        return this.repository.findByName(name.toString()).map(this.converter::toDomain);
    }

    @Override
    public Container findByNameOrThrow(ContainerName name) {
        return this.findByName(name).orElseThrow(() -> new ContainerNotFoundException(name));
    }

    @Override
    public Container save(Container container) {
        return converter.toDomain(repository.save(converter.toEntity(container)));
    }

    @Override
    public boolean exists(ContainerName name) {
        return repository.existsByName(name.toString());
    }
}
