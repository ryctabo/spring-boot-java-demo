package com.ryctabo.demo.infrastructure.service;

import com.ryctabo.demo.domain.IdGenerator;
import com.ryctabo.demo.domain.container.valueobjects.ContainerId;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultIdGenerator implements IdGenerator {
    @Override
    public ContainerId containerId() {
        return new ContainerId(UUID.randomUUID().toString());
    }
}
