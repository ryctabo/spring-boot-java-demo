package com.ryctabo.demo.infrastructure.repository.container;

import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface PostgresContainerRepository extends Repository<ContainerEntity, String> {
    Optional<ContainerEntity> findById(String id);
    Optional<ContainerEntity> findByName(String name);
    ContainerEntity save(ContainerEntity entity);
    boolean existsByName(String name);
}
