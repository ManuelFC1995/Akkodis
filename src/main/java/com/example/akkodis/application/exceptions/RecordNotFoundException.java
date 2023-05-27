package com.example.akkodis.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {

    private String exceptionDetail;


    public RecordNotFoundException(String exceptionDetail) {
        super(exceptionDetail);
        this.exceptionDetail = exceptionDetail;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

}