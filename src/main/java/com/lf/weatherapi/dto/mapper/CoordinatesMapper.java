package com.lf.weatherapi.dto.mapper;

import com.lf.weatherapi.domain.Coordinates;
import com.lf.weatherapi.dto.CoordinatesDto;
import org.springframework.stereotype.Component;

@Component
public class CoordinatesMapper {

    public CoordinatesDto toDto(Coordinates coordinates) {
        return new CoordinatesDto.CoordinatesDtoBuilder()
                .setLon(coordinates.getLon())
                .setLat(coordinates.getLat())
                .build();
    }
}
