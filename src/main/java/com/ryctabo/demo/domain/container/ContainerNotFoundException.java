package com.ryctabo.demo.domain.container;

import com.ryctabo.demo.domain.container.valueobjects.ContainerId;
import com.ryctabo.demo.domain.container.valueobjects.ContainerName;

public class ContainerNotFoundException extends RuntimeException {
    public ContainerNotFoundException(ContainerId id) {
        super("Container with ID %s was not found".formatted(id));
    }

    public ContainerNotFoundException(ContainerName name) {
        super("Container with name %s was not found!".formatted(name));
    }
}
