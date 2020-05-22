package br.com.challenge.locationservices.service;

import br.com.challenge.locationservices.endpoint.resource.LocationResource;

public interface LocationService {

    LocationResource findByPostalCode(String postalCode);
}
