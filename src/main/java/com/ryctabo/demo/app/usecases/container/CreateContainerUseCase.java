package com.ryctabo.demo.app.usecases.container;

import com.ryctabo.demo.app.usecases.UseCase;
import com.ryctabo.demo.domain.container.Container;

public interface CreateContainerUseCase
        extends UseCase<CreateContainerCommand, Container> { }
