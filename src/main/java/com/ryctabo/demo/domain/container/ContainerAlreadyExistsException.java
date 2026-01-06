package com.ryctabo.demo.domain.container;

import com.ryctabo.demo.domain.container.valueobjects.ContainerName;

public class ContainerAlreadyExistsException extends ContainerException {
    public ContainerAlreadyExistsException(ContainerName name) {
        super("Container (%s) already exists!".formatted(name));
    }
}
