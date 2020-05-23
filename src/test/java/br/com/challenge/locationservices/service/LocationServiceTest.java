package br.com.challenge.locationservices.service;

import br.com.challenge.locationservices.infra.exception.BadRequestExcepption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThrows;

@RunWith(SpringRunner.class)
public class LocationServiceTest {

    private final String POSTAL_CODE_VALID = "08295789";
    private final String POSTAL_CODE_INVALID = "123456789";

    @Autowired
    private LocationService locationService;

    @Test
    public void givenPostalCodeInvalidWhenMethodValidateReturnBadRequest() {
        assertThrows(BadRequestExcepption.class, () -> {
            locationService.findByPostalCode(POSTAL_CODE_VALID);
        });
    }


}
