package com.ryctabo.demo.infrastructure.repository.container;

import com.ryctabo.demo.domain.container.Container;
import com.ryctabo.demo.domain.container.valueobjects.ContainerId;
import com.ryctabo.demo.domain.core.Country;
import com.ryctabo.demo.domain.core.Warehouse;
import com.ryctabo.demo.domain.location.LocationName;
import com.ryctabo.demo.infrastructure.repository.Converter;
import org.springframework.stereotype.Component;

@Component
public class ContainerConverter implements Converter<Container, ContainerEntity> {

    @Override
    public Container toDomain(ContainerEntity entity) {
        return new Container(
                new ContainerId(entity.getId()),
                entity.getNumber(),
                new LocationName(entity.getLocationName()),
                new Warehouse(entity.getWarehouse()),
                new Country(entity.getCountry()),
                entity.getCreatedAt()
        );
    }

    @Override
    public ContainerEntity toEntity(Container data) {
        return new ContainerEntity(
                data.getId().toString(),
                data.name().toString(),
                data.getNumber(),
                data.getLocationName().toString(),
                data.getWarehouse().toString(),
                data.getCountry().toString(),
                data.getCreatedAt()
        );
    }
}
