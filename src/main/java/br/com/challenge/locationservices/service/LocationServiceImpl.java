package br.com.challenge.locationservices.service;

import br.com.challenge.locationservices.endpoint.resource.LocationResource;
import br.com.challenge.locationservices.infra.exception.ValidationException;
import br.com.challenge.locationservices.infra.exception.code.ErrorCodes;
import br.com.challenge.locationservices.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public LocationResource findByPostalCode(String postalCode){
        validate(postalCode);
        return locationRepository.findByPostalCode(postalCode);
    }

    private void validate(final String postalCode) {
        if (postalCode.isEmpty()) {
            throw new ValidationException(ErrorCodes.POSTAL_CODE_IS_MANDATORY);
        }

        final String POSTAL_CODE_REGEX = "[0-9]{8}";
        if (!postalCode.matches(POSTAL_CODE_REGEX)) {
            throw new ValidationException(ErrorCodes.INVALID_POSTAL_CODE);
        }
    }
}
