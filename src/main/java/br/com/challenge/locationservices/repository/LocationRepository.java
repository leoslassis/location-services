package br.com.challenge.locationservices.repository;

import br.com.challenge.locationservices.converter.LocationConverterImpl;
import br.com.challenge.locationservices.endpoint.resource.LocationResource;
import br.com.challenge.locationservices.infra.exception.NotFoundException;
import br.com.challenge.locationservices.infra.exception.code.ErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LocationRepository {

    @Autowired
    private LocationJpaRepository locationJpaRepository;

    @Autowired
    private LocationConverterImpl converter;

    public LocationResource findByPostalCode(String postalCode) {
        return converter.fromResource(locationJpaRepository.findByPostalCode(postalCode)
                .orElse(converter.toEntity(findByPostalCode(assignZeroToTheEnd(postalCode)))));
    }

    private String assignZeroToTheEnd(String postalCode) {

        char[] chars = postalCode.toCharArray();
        for(char character : chars){
            if (character!= '0') {
                postalCode.replace(character, '0');
                break;
            }
        }

        if(postalCode.matches("[0]+")){
            throw new NotFoundException(ErrorCodes.POSTAL_CODE_NOT_FOUND);
        }

        return postalCode;

    }
}
