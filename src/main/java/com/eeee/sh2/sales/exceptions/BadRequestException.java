package com.eeee.sh2.sales.exceptions;

/**
 * Created by Charles on 15/06/2017.
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
