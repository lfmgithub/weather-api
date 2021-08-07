package com.lf.weatherapi.dto;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value = "Location")
public class LocationDto extends DtoModel {

    private int id;
    private CoordinatesDto coordinates;
    private String locationName;
    private List<ConditionDto> weather;
    private ValuesDto values;
    private CountryDto country;
    private long date;

    public LocationDto(int id, CoordinatesDto coordinates, String locationName, List<ConditionDto> weather, ValuesDto values, CountryDto country, long date) {
        this.id = id;
        this.coordinates = coordinates;
        this.locationName = locationName;
        this.weather = weather;
        this.values = values;
        this.country = country;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CoordinatesDto getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinatesDto coordinates) {
        this.coordinates = coordinates;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public List<ConditionDto> getWeather() {
        return weather;
    }

    public void setWeather(List<ConditionDto> weather) {
        this.weather = weather;
    }

    public ValuesDto getValues() {
        return values;
    }

    public void setValues(ValuesDto values) {
        this.values = values;
    }

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public static class LocationDtoBuilder {

        private int id;
        private CoordinatesDto coordinates;
        private String locationName;
        private List<ConditionDto> weather;
        private ValuesDto values;
        private CountryDto country;
        private long date;

        public LocationDtoBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public LocationDtoBuilder setCoordinates(CoordinatesDto coordinatesDto) {
            this.coordinates = coordinatesDto;
            return this;
        }

        public LocationDtoBuilder setLocationName(String locationName) {
            this.locationName = locationName;
            return this;
        }

        public LocationDtoBuilder setWeather(List<ConditionDto> weather) {
            this.weather = weather;
            return this;
        }

        public LocationDtoBuilder setValues(ValuesDto valuesDto) {
            this.values = valuesDto;
            return this;
        }

        public LocationDtoBuilder setCountry(CountryDto countryDto) {
            this.country = countryDto;
            return this;
        }

        public LocationDtoBuilder setDate(long date) {
            this.date = date;
            return this;
        }

        public LocationDto build() {
            return new LocationDto(id, coordinates, locationName, weather, values, country, date);
        }
    }
}
