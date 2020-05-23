package br.com.challenge.locationservices.repository;

import br.com.challenge.locationservices.LocationServicesApplication;
import br.com.challenge.locationservices.endpoint.resource.LocationResource;
import br.com.challenge.locationservices.repository.entity.LocationEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {LocationServicesApplication.class})
@Sql({"/sql/clean-all.sql", "/sql/location-endpoint.sql"})
public class LocationRepositoryTest {

    private final String POSTAL_CODE_VALID = "08295789";
    private final String POSTAL_CODE_INVALID = "123456789";

    @Autowired
    private LocationJpaRepository locationRepository;

    @Test
    public void givenPostalCodeValidWhenFindFindByPostalCodeThenReturnLocation() {
        Optional<LocationEntity> location = locationRepository.findByPostalCode(POSTAL_CODE_VALID);
        assertThat(location.isPresent()).isEqualTo(true);
    }

    @Test
    public void givenPostalCodeInvalidWhenFindFindByPostalCodeThenReturnOptionalEmpty() {
        Optional<LocationEntity> location = locationRepository.findByPostalCode(POSTAL_CODE_INVALID);
        assertThat(location.isPresent()).isEqualTo(false);
    }
}
