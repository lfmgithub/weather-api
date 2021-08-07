package com.lf.weatherapi.dto.mapper;

import com.lf.weatherapi.domain.Location;
import com.lf.weatherapi.dto.LocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class LocationMapper {

    @Autowired
    private ConditionMapper conditionMapper;
    @Autowired
    private ValuesMapper valuesMapper;
    @Autowired
    private CountryMapper countryMapper;
    @Autowired
    private CoordinatesMapper coordinatesMapper;

    public LocationDto toDto(Location location) {
        return new LocationDto.LocationDtoBuilder()
                .setId(location.getId())
                .setLocationName(location.getLocationName())
                .setCoordinates(coordinatesMapper.toDto(location.getCoordinates()))
                .setWeather(location.getWeather().stream().map(condition -> conditionMapper.toDto(condition)).collect(Collectors.toList()))
                .setValues(valuesMapper.toDto(location.getValues()))
                .setCountry(countryMapper.toDto(location.getCountry()))
                .setDate(location.getDate())
                .build();
    }
}
