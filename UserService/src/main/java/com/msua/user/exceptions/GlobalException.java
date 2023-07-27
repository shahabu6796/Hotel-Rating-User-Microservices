package com.msua.user.exceptions;

import com.msua.user.payload.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseApi> handleResourceNotFoundException(ResourceNotFoundException ex){
        ResponseApi response = ResponseApi.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ResponseApi>(response,HttpStatus.NOT_FOUND);
    }
}
