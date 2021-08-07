package com.lf.weatherapi.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Values")
public class ValuesDto extends DtoModel {

    private float temp;
    private float feelsLike;
    private float tempMin;
    private float tempMax;
    private float humidity;

    public ValuesDto(float temp, float feelsLike, float tempMin, float tempMax, float humidity) {
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.humidity = humidity;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(float feelsLike) {
        this.feelsLike = feelsLike;
    }

    public float getTempMin() {
        return tempMin;
    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public static class ValuesDtoBuilder {

        private float temp;
        private float feelsLike;
        private float tempMin;
        private float tempMax;
        private float humidity;

        public ValuesDto.ValuesDtoBuilder setTemp(float temp) {
            this.temp = temp;
            return this;
        }

        public ValuesDto.ValuesDtoBuilder setFeelsLike(float feelsLike) {
            this.feelsLike = feelsLike;
            return this;
        }

        public ValuesDto.ValuesDtoBuilder setTempMin(float tempMin) {
            this.tempMin = tempMin;
            return this;
        }

        public ValuesDto.ValuesDtoBuilder setTempMax(float tempMax) {
            this.tempMax = tempMax;
            return this;
        }

        public ValuesDto.ValuesDtoBuilder setHumidity(float humidity) {
            this.humidity = humidity;
            return this;
        }

        public ValuesDto build() {
            return new ValuesDto(temp, feelsLike, tempMin, tempMax, humidity);
        }
    }
}
