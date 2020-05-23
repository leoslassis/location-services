package br.com.challenge.locationservices.repository;

import br.com.challenge.locationservices.endpoint.resource.LocationResource;

public interface LocationRepository {

    LocationResource findByPostalCode(String postalCode);

}
