package com.ryctabo.demo.app.usecases.container;

import com.ryctabo.demo.domain.container.valueobjects.ContainerName;
import com.ryctabo.demo.domain.core.Country;
import com.ryctabo.demo.domain.location.LocationName;

public record CreateContainerCommand(
        ContainerName name,
        LocationName locationName,
        Country country
) { }
