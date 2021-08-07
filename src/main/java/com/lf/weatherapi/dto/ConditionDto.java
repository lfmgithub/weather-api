package com.lf.weatherapi.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Condition")
public class ConditionDto extends DtoModel {

    private String conditionDescription;

    public ConditionDto(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    public static class ConditionDtoBuilder {

        private String conditionDescription;

        public ConditionDtoBuilder setConditionDescription(String conditionDescription) {
            this.conditionDescription = conditionDescription;
            return this;
        }

        public ConditionDto build() {
            return new ConditionDto(conditionDescription);
        }
    }
}
