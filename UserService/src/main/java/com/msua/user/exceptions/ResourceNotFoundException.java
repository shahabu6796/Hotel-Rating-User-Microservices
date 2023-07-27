package com.msua.user.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    // add your constructor based on your requirements
    public ResourceNotFoundException(){
        super("Resource Not found");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
