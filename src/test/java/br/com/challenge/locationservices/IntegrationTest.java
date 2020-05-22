package br.com.challenge.locationservices;

import org.junit.Before;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

public class IntegrationTest {

	public final Map<String, String> headers = new HashMap<>();

	@LocalServerPort
	protected int port;

	@Before
	public void setupClassBefore(){
		headers.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
	}

	public int getPort() {
		return port;
	}

	protected String linkEndingWith(final String path) {
		return "http://localhost:" + port + path;
	}

}
