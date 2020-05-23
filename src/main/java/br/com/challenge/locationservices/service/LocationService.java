package br.com.challenge.locationservices.service;

import br.com.challenge.locationservices.endpoint.resource.LocationResource;
import org.springframework.stereotype.Service;

@Service
public interface LocationService {

    LocationResource findByPostalCode(String postalCode);
}
