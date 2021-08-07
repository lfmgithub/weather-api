package com.lf.weatherapi.dto.mapper;

import com.lf.weatherapi.domain.Condition;
import com.lf.weatherapi.dto.ConditionDto;
import org.springframework.stereotype.Component;

@Component
public class ConditionMapper {

    public ConditionDto toDto(Condition condition) {
        return new ConditionDto.ConditionDtoBuilder()
                .setConditionDescription(condition.getConditionDescription())
                .build();
    }
}
