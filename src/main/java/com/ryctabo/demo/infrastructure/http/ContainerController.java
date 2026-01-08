package com.ryctabo.demo.infrastructure.http;

import com.ryctabo.demo.app.usecases.container.CreateContainerService;
import com.ryctabo.demo.domain.container.Container;
import com.ryctabo.demo.domain.container.ContainerRepository;
import com.ryctabo.demo.domain.container.valueobjects.ContainerName;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/containers")
public class ContainerController {

    private final ContainerRepository repository;
    private final CreateContainerService createContainer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContainerResponse create(@RequestBody ContainerRequest req) {
        var container = createContainer.invoke(req.toCommand());
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
