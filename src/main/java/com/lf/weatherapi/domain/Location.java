package com.lf.weatherapi.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Location extends DomainEntity {

    @SerializedName("id")
    private int id;

    @SerializedName("coord")
    private Coordinates coordinates;

    @SerializedName("name")
    private String locationName;

    @SerializedName("weather")
    private List<Condition> weather;

    @SerializedName("main")
    private Values values;

    @SerializedName("sys")
    private Country country;

    @SerializedName("dt")
    private long date;

    public Location(int id, Coordinates coordinates, String locationName, List<Condition> weather, Values values, Country country, long date) {
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public List<Condition> getWeather() {
        return weather;
    }

    public void setWeather(List<Condition> weather) {
        this.weather = weather;
    }

    public Values getValues() {
        return values;
    }

    public void setValues(Values values) {
        this.values = values;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
