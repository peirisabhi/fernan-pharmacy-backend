package com.chathra.fernanPharmacyBackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 01/11/2021
 * Time: 9:09 am
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;

//    private ApiResponse apiResponse;
//
//    public BadRequestException(ApiResponse apiResponse) {
//        super();
//        this.apiResponse = apiResponse;
//    }
//
//    public BadRequestException(String message) {
//        super(message);
//    }
//
//    public BadRequestException(String message, Throwable cause) {
//        super(message, cause);
//    }
//
//    public ApiResponse getApiResponse() {
//        return apiResponse;
//    }

    private final HttpStatus status;
    private final String message;

    public BadRequestException(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public BadRequestException(HttpStatus status, String message, Throwable exception) {
        super(exception);
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
