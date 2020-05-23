package br.com.challenge.locationservices.service;

import br.com.challenge.locationservices.LocationServicesApplication;
import br.com.challenge.locationservices.infra.exception.BadRequestExcepption;
import br.com.challenge.locationservices.infra.exception.ValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {LocationServicesApplication.class})
@Sql({"/sql/clean-all.sql", "/sql/location-endpoint.sql"})
public class LocationServiceTest {

    private final String POSTAL_CODE_VALID = "08295789";
    private final String POSTAL_CODE_INVALID = "123456789";
    private final String POSTAL_CODE_EMPTY = "";

    @Autowired
    private LocationService locationService;

    @Test
    public void givenPostalCodeInvalidWhenMethodValidateReturnBadRequest() {
        assertThrows(ValidationException.class, () -> {
            locationService.findByPostalCode(POSTAL_CODE_INVALID);
        });
    }

    @Test
    public void givenPostalCodeEmptyWhenMethodValidateReturnBadRequest() {
        assertThrows(ValidationException.class, () -> {
            locationService.findByPostalCode(POSTAL_CODE_EMPTY);
        });
    }

    @Test
    public void givenPostalCodeValidWhenMethodValidateReturnLocationOk() {
        assertThat(locationService.findByPostalCode(POSTAL_CODE_VALID))
                .isNotNull();
    }


}
