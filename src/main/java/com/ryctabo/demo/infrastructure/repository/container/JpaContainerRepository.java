package com.ryctabo.demo.infrastructure.repository.container;

import com.ryctabo.demo.domain.container.Container;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface JpaContainerRepository extends Repository<ContainerEntity, String> {
    Optional<ContainerEntity> findById(String id);
    Optional<ContainerEntity> findByName(String name);
    ContainerEntity save(ContainerEntity entity);
    boolean existsByName(String name);
}
