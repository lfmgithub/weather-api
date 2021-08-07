package com.lf.weatherapi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = WeatherApiApplication.class)
public class WeatherApiApplicationIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int port;

    private static HttpHeaders headers;
    private static HttpEntity<String> header;

    @BeforeAll
    static void setUp() {
        headers = new HttpHeaders();
        headers.set("Authorization", "invalidKey");
        header = new HttpEntity<>(headers);
    }

    @Test
    public void whenInvalidKeyRequestsValidResource_ThenSuccess() {
        final String url = "http://localhost:" + port + "/api/weather?params=London";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, header, String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

    @Test
    public void whenParamsIsMissing_ThenBadRequest() {
        final String url = "http://localhost:" + port + "/api/weather?";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, header, String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void whenUnauthorizedRequestsHealth_ThenSuccess() {
        final String url = "http://localhost:" + port + "/api/health";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}