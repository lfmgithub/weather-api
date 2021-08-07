package com.lf.weatherapi.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Country")
public class CountryDto extends DtoModel {

    private int id;
    private String countryCode;

    public CountryDto(int id, String countryCode) {
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

    public static class CountryDtoBuilder {

        private int id;
        private String countryCode;

        public CountryDto.CountryDtoBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public CountryDto.CountryDtoBuilder setCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public CountryDto build() {
            return new CountryDto(id, countryCode);
        }
    }
}
