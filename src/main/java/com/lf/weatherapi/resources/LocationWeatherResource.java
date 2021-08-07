package com.lf.weatherapi.resources;

import com.lf.weatherapi.dto.LocationDto;
import com.lf.weatherapi.dto.mapper.LocationMapper;
import com.lf.weatherapi.services.LocationWeatherService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value="Weather API")
@RestController
@RequestMapping(value = "/api/weather")
public class LocationWeatherResource {

    @Autowired
    private LocationWeatherService locationWeatherService;

    @Autowired
    private LocationMapper locationMapper;

    @GetMapping
    @ApiOperation(value = "Get the current weather from many locations.")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Data source is not available")
    })
    public ResponseEntity<LocationDto> retrieveLocationWeather(
            @ApiParam(name =  "params", type = "String", value = "City name or city name and country", example = "London,uk", required = true) @RequestParam String params) {
        return ResponseEntity.ok().body(locationMapper.toDto(locationWeatherService.getWeather(params)));
    }
}
