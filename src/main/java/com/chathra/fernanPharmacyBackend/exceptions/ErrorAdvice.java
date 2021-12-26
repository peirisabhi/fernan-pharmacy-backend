package com.chathra.fernanPharmacyBackend.exceptions;

import com.chathra.fernanPharmacyBackend.constant.ErrorCodes;
import com.chathra.fernanPharmacyBackend.payload.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException ex) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(ErrorCodes.LS001)
                .message(ex.getMessage())
                .variable(ex.getVariable())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

    }

    @ExceptionHandler(DuplicateDataFoundException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateDataFoundException(DuplicateDataFoundException ex) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(ErrorCodes.LS002)
                .message(ex.getMessage())
                .variable(ex.getVariable())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

    }


}
