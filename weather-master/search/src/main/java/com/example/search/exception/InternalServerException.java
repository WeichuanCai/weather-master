package com.example.search.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InternalServerException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> internalServerException(Exception ex,
                                                               HttpServletRequest request,
                                                               HttpServletResponse response) {
        if (ex instanceof NullPointerException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
