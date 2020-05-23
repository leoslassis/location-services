package br.com.challenge.locationservices.endpoit;

import br.com.challenge.locationservices.IntegrationTest;
import br.com.challenge.locationservices.LocationServicesApplication;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {LocationServicesApplication.class})
@Sql({"/sql/clean-all.sql", "/sql/location-endpoint.sql"})
public class LocationEndpointGetIT extends IntegrationTest {

	@Test
	public void shouldReturnLocationOkWhenPostalCodeParamExisting() {
		get("/rs/location?postalCode=08295789")
				.statusCode(HttpStatus.OK.value())
				.header("Content-Type", startsWith(MediaType.APPLICATION_JSON.toString()))
				.body("id", is(4))
				.body("street", is("Rua D"))
				.body("district", is("Bairro D"))
				.body("city", is("Cidade D"))
				.body("state", is("Estado D"))
				.body("postalCode", is("08295789"));
	}

	@Test
	public void shouldReturnLocationOkWhenIncrementToTheEndPostalCode() {
		get("/rs/location?postalCode=08295178")
				.statusCode(HttpStatus.OK.value())
				.header("Content-Type", startsWith(MediaType.APPLICATION_JSON.toString()))
				.body("id", is(5))
				.body("street", is("Rua E"))
				.body("district", is("Bairro E"))
				.body("city", is("Cidade E"))
				.body("state", is("Estado E"))
				.body("postalCode", is("08295100"));
	}

	@Test
	public void shouldReturnLocationNotFoundWhenPostalCodeParamNonExistent() {
		get("/rs/location?postalCode=32165487")
				.statusCode(HttpStatus.NOT_FOUND.value())
				.body("errors[0].code", is(404002))
				.body("errors[0].message", is("Location Not Found"));
	}

	@Test
	public void shouldReturnLocationBadRequestWhenPostalCodeParamIsEmpty() {
		get("/rs/location?postalCode=")
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.body("errors[0].code", is(400002))
				.body("errors[0].message", is("Postal code is mandatory"));
	}

	@Test
	public void shouldReturnLocationBadRequestWhenWhenPostalCodeParamIsInvalid() {
		get("/rs/location?postalCode=123654")
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.body("errors[0].code", is(400003))
				.body("errors[0].message", is("Invalid postal code"));
	}

	private ValidatableResponse get(String uri) {
		return given().port(port)
				.log().all(true)
				.headers(headers)
				.get(uri)
				.then().log().all(true);
	}

}
