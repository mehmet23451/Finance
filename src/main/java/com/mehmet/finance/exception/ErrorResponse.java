package com.mehmet.finance.exception;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ErrorResponse {
    private LocalDateTime errorDateTime;
    private int status;
    private String errorMessage;
    public ErrorResponse(int status, String errorMessage){
        this.errorDateTime= LocalDateTime.now();
        this.status=status;
        this.errorMessage=errorMessage;
    }
}
