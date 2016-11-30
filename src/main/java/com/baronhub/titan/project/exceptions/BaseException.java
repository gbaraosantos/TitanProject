package com.baronhub.titan.project.exceptions;

/**
 * Exception Abstraction
 */
public class BaseException extends Exception{
    private final String message;

    /**
     * Exception Constructor
     * @param msg Message from exception
     */
    public BaseException(String msg){
        this.message = msg;
    }

    /**
     * Get Exception Message
     * @return String message
     */
    @Override
    public String getMessage(){
        return message;
    }
}
