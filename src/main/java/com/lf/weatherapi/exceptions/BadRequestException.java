package com.lf.weatherapi.exceptions;

public class BadRequestException extends CustomException {

    public BadRequestException(String msg) {
        super(msg);
    }
}