package com.ryctabo.demo.infrastructure.service;

import com.ryctabo.demo.domain.IdGenerator;
import com.ryctabo.demo.domain.container.valueobjects.ContainerId;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DefaultIdGenerator implements IdGenerator {
    @Override
    public ContainerId containerId() {
        return new ContainerId(UUID.randomUUID().toString());
    }
}
