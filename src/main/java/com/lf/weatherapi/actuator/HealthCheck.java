package com.lf.weatherapi.actuator;

import com.lf.weatherapi.services.LocationWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("Data source")
public class HealthCheck implements HealthIndicator {

    @Autowired
    private LocationWeatherService locationWeatherService;

    @Override
    public Health health() {
        boolean errorCode = locationWeatherService.isAvailable();
        if (!errorCode) {
            return Health.down().withDetail("Error", "Source not available.").build();
        }
        return Health.up().build();
    }
}
