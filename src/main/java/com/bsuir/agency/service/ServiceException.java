package com.bsuir.agency.service;

public class ServiceException extends RuntimeException {

    private String message;

    public ServiceException(String message){
        super(message);
        this.message = message;
    }

    public ServiceException(String message, Exception ex){
        super(message, ex);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString(){
        return message;
    }
}
