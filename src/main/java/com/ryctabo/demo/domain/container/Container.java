package com.ryctabo.demo.domain.container;

import com.ryctabo.demo.domain.container.valueobjects.ContainerId;
import com.ryctabo.demo.domain.container.valueobjects.ContainerName;
import com.ryctabo.demo.domain.core.Country;
import com.ryctabo.demo.domain.core.Warehouse;
import com.ryctabo.demo.domain.location.LocationName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Container {

    private final ContainerId id;
    private final int number;
    private LocationName locationName;
    private final Warehouse warehouse;
    private final Country country;
    private final Instant createdAt;

    public static Container createByName(ContainerId id, ContainerName name, LocationName locationName, Country country, Instant createdAt) {
        var arr = name.value().split("-LPN-");
        var warehouse = new Warehouse(arr[0]);
        var number = Integer.parseInt(arr[1]);
        return new Container(id, number, locationName, warehouse, country, createdAt);
    }

    public ContainerName name() {
        return new ContainerName("%s-LPN-%08d".formatted(warehouse, number));
    }
}
