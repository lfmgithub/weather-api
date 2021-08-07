package com.lf.weatherapi.exceptions;

import com.lf.weatherapi.util.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @Autowired
    private DateFormatter dateFormatter;

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(dateFormatter.formatToISO8601(), status.value(), "Not Found",
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);

    }

    @ExceptionHandler(ServerNotAvailableException.class)
    public ResponseEntity<StandardError> serverNotAvailable(ServerNotAvailableException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        StandardError error = new StandardError(dateFormatter.formatToISO8601(), status.value(), "Data source is not available",
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);

    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<StandardError> apiKeyNotValid(UnauthorizedException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        StandardError error = new StandardError(dateFormatter.formatToISO8601(), status.value(), "Unauthorized",
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);

    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandardError> badRequest(BadRequestException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(dateFormatter.formatToISO8601(), status.value(), "Bad Request",
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);

    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<StandardError> badRequest(MissingServletRequestParameterException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(dateFormatter.formatToISO8601(), status.value(), "Bad Request",
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);

    }

}
