package com.lf.weatherapi.exceptions;

public class UnauthorizedException extends CustomException {

    public UnauthorizedException(String msg) {
        super(msg);
    }
}