package com.lf.weatherapi.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateFormatter {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public String formatToISO8601() {
        LocalDateTime ldt = LocalDateTime.now();
        return DATE_TIME_FORMATTER.format(ldt);
    }
}
