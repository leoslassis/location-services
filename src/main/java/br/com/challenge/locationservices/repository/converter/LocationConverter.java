package br.com.challenge.locationservices.repository.converter;

import br.com.challenge.locationservices.endpoint.resource.LocationResource;
import br.com.challenge.locationservices.repository.entity.LocationEntity;

public interface LocationConverter {

    LocationEntity toEntity(LocationResource resource);

    LocationResource fromResource(LocationEntity resource);
}
