package com.baronhub.titan.project.exceptions;

/**
 * Exception Abstraction
 */
public class BaseException extends Exception{
    private String message;

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
    public String getMessage(){
        return message;
    }
}
