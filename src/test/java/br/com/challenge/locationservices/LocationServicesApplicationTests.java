package br.com.challenge.locationservices;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {LocationServicesApplication.class})
@Sql({"/sql/clean-all.sql", "/sql/location-endpoint.sql"})
class LocationServicesApplicationTests extends IntegrationTest{

	@Test
	void contextLoads() {
	}

	@org.junit.Test
	public void shouldReturnAllCampaigns() {
		get("/location?postalCode=32165487")
				.statusCode(HttpStatus.NOT_FOUND.value());
	}

	private ValidatableResponse get(String uri) {
		return given().port(port)
				.log().all(true)
				.headers(headers)
				.get(uri)
				.then().log().all(true);
	}

}
