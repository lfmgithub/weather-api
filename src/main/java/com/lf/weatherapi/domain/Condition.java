package com.lf.weatherapi.domain;

import com.google.gson.annotations.SerializedName;

public class Condition extends DomainEntity {

    @SerializedName("description")
    private String conditionDescription;

    public Condition(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }
}
