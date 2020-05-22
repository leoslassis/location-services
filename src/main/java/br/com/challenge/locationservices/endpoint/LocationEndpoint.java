package br.com.challenge.locationservices.endpoint;

import br.com.challenge.locationservices.endpoint.resource.LocationResource;
import br.com.challenge.locationservices.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationEndpoint {

    @Autowired
    private LocationServiceImpl locationService;

    @GetMapping
    public ResponseEntity<LocationResource> findByPostalCode(@RequestParam("postalCode") String postalCode){
        return ResponseEntity.ok(locationService.findByPostalCode(postalCode));
    }
}
