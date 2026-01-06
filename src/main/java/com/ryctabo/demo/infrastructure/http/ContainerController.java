package com.ryctabo.demo.infrastructure.http;

import com.ryctabo.demo.app.usecases.CreateContainer;
import com.ryctabo.demo.domain.container.Container;
import com.ryctabo.demo.domain.container.ContainerRepository;
import com.ryctabo.demo.domain.container.valueobjects.ContainerName;
import com.ryctabo.demo.domain.core.Country;
import com.ryctabo.demo.domain.location.LocationName;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/containers")
public class ContainerController {

    private final ContainerRepository repository;
    private final CreateContainer createContainer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContainerResponse create(@RequestBody ContainerRequest req) {
        var container = createContainer.invoke(
                new ContainerName(req.name()),
                new LocationName(req.location()),
                new Country(req.country()));
        return convert(container);
    }

    @GetMapping("/{name}")
    public ContainerResponse get(@PathVariable String name) {
        var container = repository.findByNameOrThrow(new ContainerName(name));
        return convert(container);
    }

    private static @NonNull ContainerResponse convert(Container container) {
        return new ContainerResponse(
                container.getId().toString(),
                container.name().toString(),
                container.getNumber(),
                container.getLocationName().toString(),
                container.getWarehouse().toString(),
                container.getCountry().toString(),
                container.getCreatedAt()
        );
    }
}
