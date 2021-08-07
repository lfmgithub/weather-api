package com.lf.weatherapi.dto.mapper;

import com.lf.weatherapi.domain.Country;
import com.lf.weatherapi.dto.CountryDto;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public CountryDto toDto(Country country) {
        return new CountryDto.CountryDtoBuilder()
                .setId(country.getId())
                .setCountryCode(country.getCountryCode())
                .build();
    }
}
