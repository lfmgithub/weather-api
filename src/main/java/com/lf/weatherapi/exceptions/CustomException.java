package com.lf.weatherapi.exceptions;

public abstract class CustomException extends RuntimeException {

    protected CustomException(String msg) {
        super(msg);
    }
}
