package br.com.challenge.locationservices.repository;

import br.com.challenge.locationservices.endpoint.resource.LocationResource;
import br.com.challenge.locationservices.infra.exception.NotFoundException;
import br.com.challenge.locationservices.infra.exception.code.ErrorCodes;
import br.com.challenge.locationservices.repository.converter.LocationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LocationRepositoryImpl implements LocationRepository{

    @Autowired
    private LocationJpaRepository locationJpaRepository;

    @Autowired
    private LocationConverter converter;

    public LocationResource findByPostalCode(String postalCode) {
        return converter.fromResource(locationJpaRepository.findByPostalCode(postalCode)
                .orElseGet(() -> converter.toEntity(findByPostalCode(assignZeroToTheEnd(postalCode)))));
    }

    public String assignZeroToTheEnd(String postalCode) {

        StringBuilder postalCodeBuilder = new StringBuilder(postalCode);

        for (int i = postalCodeBuilder.length(); i > 0; i--) {
            if (postalCodeBuilder.charAt(i - 1) != '0') {
                postalCodeBuilder.setCharAt(i - 1, '0');
                break;
            }
        }

        if(postalCode.matches("[0]+")){
            throw new NotFoundException(ErrorCodes.POSTAL_CODE_NOT_FOUND);
        }

        return postalCodeBuilder.toString();

    }
}
