package com.lf.weatherapi.dto.mapper;

import com.lf.weatherapi.domain.Values;
import com.lf.weatherapi.dto.ValuesDto;
import org.springframework.stereotype.Component;

@Component
public class ValuesMapper {

    public ValuesDto toDto(Values values) {
        return new ValuesDto.ValuesDtoBuilder()
                .setFeelsLike(values.getFeelsLike())
                .setHumidity(values.getHumidity())
                .setTemp(values.getTemp())
                .setTempMax(values.getTempMax())
                .setTempMin(values.getTempMin())
                .build();
    }
}
