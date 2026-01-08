package com.ryctabo.demo.infrastructure.http;

import com.ryctabo.demo.app.usecases.container.CreateContainerCommand;
import com.ryctabo.demo.domain.container.valueobjects.ContainerName;
import com.ryctabo.demo.domain.core.Country;
import com.ryctabo.demo.domain.location.LocationName;

public record ContainerRequest(
        String name,
        String location,
        String country
) {
    public CreateContainerCommand toCommand() {
        return new CreateContainerCommand(
                new ContainerName(name),
                new LocationName(location),
                new Country(country)
        );
    }
}
