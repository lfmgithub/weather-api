package com.lf.weatherapi.domain;

import com.google.gson.annotations.SerializedName;

public class Country extends DomainEntity {

    @SerializedName("id")
    private int id;

    @SerializedName("country")
    private String countryCode;

    public Country(int id, String countryCode) {
        this.id = id;
        this.countryCode = countryCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
