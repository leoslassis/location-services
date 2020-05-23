package br.com.challenge.locationservices.endpoint;

import br.com.challenge.locationservices.endpoint.resource.LocationResource;
import br.com.challenge.locationservices.service.LocationService;
import br.com.challenge.locationservices.service.LocationServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Location API REST")
@RestController
@RequestMapping("/rs/location")
public class LocationEndpoint {

    @Autowired
    private LocationService locationService;

    @ApiOperation(value = "Buscar localização através do CEP")
    @GetMapping
    public ResponseEntity<LocationResource> findByPostalCode(
            @RequestParam(name = "postalCode", required = true) String postalCode){
        return ResponseEntity.ok(locationService.findByPostalCode(postalCode));
    }
}
