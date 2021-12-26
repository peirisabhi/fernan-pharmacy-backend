package com.chathra.fernanPharmacyBackend.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private final String message;

    private final String variable;

    @JsonProperty(value = "error_code")
    private final String errorCode;

}
