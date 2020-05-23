package br.com.challenge.locationservices.endpoit.converter;

import br.com.challenge.locationservices.LocationServicesApplication;
import br.com.challenge.locationservices.endpoint.resource.LocationResource;
import br.com.challenge.locationservices.repository.converter.LocationConverter;
import br.com.challenge.locationservices.repository.entity.LocationEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LocationServicesApplication.class)
@WebAppConfiguration
public class LocationConverterTest {

    @Autowired
    LocationConverter converter;

    LocationEntity entity = null;
    LocationResource resource = null;

    @Before
    public void setUp() {
    entity = new LocationEntity(
            1L,
            "Rua A",
            "Bairro A",
            "Cidade A",
            "Estado A",
            "123456789");

    resource = new LocationResource(
            1L,
            "Rua A",
            "Bairro A",
            "Cidade A",
            "Estado A",
            "123456789");
    }

    @Test
    public void whenConverEntityToResource() {
        assertThat(converter.fromResource(entity))
                .isEqualToComparingFieldByField(resource);
    }

    @Test
    public void whenConveResourceTorEntity() {
        assertThat(converter.toEntity(resource))
                .isEqualToComparingFieldByField(entity);
    }
}
