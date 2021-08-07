package com.lf.weatherapi.source;

import com.lf.weatherapi.domain.Location;
import feign.RequestLine;

public interface Weather {

    @RequestLine("GET")
    Location getWeather(String params);

    @RequestLine("GET")
    boolean isAvailable();
}
