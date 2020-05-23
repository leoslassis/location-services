package br.com.challenge.locationservices.service;

import br.com.challenge.locationservices.repository.LocationRepository;
import br.com.challenge.locationservices.repository.LocationRepositoryImpl;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LocaitonServiceTest {

    @Autowired
    private LocationServiceImpl locationService;

    @Mock
    private LocationRepositoryImpl locationRepository;


}
