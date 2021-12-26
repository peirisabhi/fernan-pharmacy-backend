package com.chathra.fernanPharmacyBackend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DuplicateDataFoundException extends RuntimeException{

    private final String message;

    private final String variable;
}
