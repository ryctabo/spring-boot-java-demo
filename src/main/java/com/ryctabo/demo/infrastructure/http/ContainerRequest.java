package com.ryctabo.demo.infrastructure.http;

import com.ryctabo.demo.app.usecases.container.CreateContainerCommand;
import com.ryctabo.demo.domain.container.valueobjects.ContainerName;
import com.ryctabo.demo.domain.core.Country;
import com.ryctabo.demo.domain.location.LocationName;
import jakarta.validation.constraints.NotBlank;

public record ContainerRequest(
        @NotBlank(message = "Container value can not be blank!") String name,
        @NotBlank(message = "Location value can not be empty!") String location,
        @NotBlank(message = "Country code can not be blank!") String country
) {
    public CreateContainerCommand toCommand() {
        return new CreateContainerCommand(
                new ContainerName(name),
                new LocationName(location),
                new Country(country)
        );
    }
}
