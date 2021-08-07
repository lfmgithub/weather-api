package com.lf.weatherapi.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Coordinates")
public class CoordinatesDto extends DtoModel {

    private Double lon;
    private Double lat;

    public CoordinatesDto(Double lon, Double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public static class CoordinatesDtoBuilder {

        private Double lon;
        private Double lat;

        public CoordinatesDto.CoordinatesDtoBuilder setLon(Double lon) {
            this.lon = lon;
            return this;
        }

        public CoordinatesDto.CoordinatesDtoBuilder setLat(Double lat) {
            this.lat = lat;
            return this;
        }

        public CoordinatesDto build() {
            return new CoordinatesDto(lon, lat);
        }
    }
}
