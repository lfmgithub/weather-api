package com.lf.weatherapi.services;

import com.lf.weatherapi.config.SecurityFilter;
import com.lf.weatherapi.domain.Location;
import com.lf.weatherapi.exceptions.BadRequestException;
import com.lf.weatherapi.exceptions.ObjectNotFoundException;
import com.lf.weatherapi.exceptions.ServerNotAvailableException;
import com.lf.weatherapi.exceptions.UnauthorizedException;
import com.lf.weatherapi.source.Weather;
import feign.Feign;
import feign.FeignException;
import feign.gson.GsonDecoder;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"Location"})
public class LocationWeatherService implements Weather {

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s";

    @Cacheable(key = "#params")
    @Override
    public Location getWeather(String params) {
        Location location = null;
        String endpoint = String.format(BASE_URL, params, SecurityFilter.apiKey);
        try {
            location = Feign.builder().decoder(new GsonDecoder()).target(Weather.class, endpoint).getWeather(params);
        } catch (FeignException e) {
            switch (e.status()) {
                case 400:
                    throw new BadRequestException("Provide a location name.");
                case 401:
                    throw new UnauthorizedException("Invalid API key.");
                case 404:
                    throw new ObjectNotFoundException("Location not found, use a valid location name.");
                default:
                    if (e.status() >= 500 && e.status() < 600) {
                        throw new ServerNotAvailableException("Data source is not available, try later.");
                    }
            }
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Provide a a valid location name.");
        }
        return location;
    }

    @Override
    public boolean isAvailable() {
        String endpoint = String.format(BASE_URL, "", SecurityFilter.apiKey);
        try {
            Feign.builder().decoder(new GsonDecoder()).target(Weather.class, endpoint).isAvailable();
        } catch (FeignException e) {
            if (e.status() >= 500 && e.status() < 600) {
                return false;
            }
        }
        return true;
    }
}
