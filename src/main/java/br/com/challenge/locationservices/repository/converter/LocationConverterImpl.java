package br.com.challenge.locationservices.repository.converter;

import br.com.challenge.locationservices.endpoint.resource.LocationResource;
import br.com.challenge.locationservices.repository.entity.LocationEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationConverterImpl implements LocationConverter {

    @Autowired
    private ModelMapper mapper;

    public LocationEntity toEntity(LocationResource resource){
        LocationEntity entity = null;
        if(resource != null){
            entity = mapper.map(resource, LocationEntity.class);
        }
        return entity;
    }

    public LocationResource fromResource(LocationEntity resource){
        LocationResource entity = null;
        if(resource != null){
            entity = mapper.map(resource, LocationResource.class);
        }
        return entity;
    }
}
