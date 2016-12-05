package com.baronhub.titan.project.common.exceptions;

/**
 * Database Exceptions
 */

public class DatabaseExceptions{

    private DatabaseExceptions(){}

    /**
     * In case a query returns zero objects
     */
    public static class NoElementsException extends BaseException {
        /**
         * Error Message
         * @param msg String
         */
        public NoElementsException(String msg) {
            super(msg);
        }
    }

    /**
     * More elements than expected
     */
    public static class MoreThanExpectedException extends BaseException {
        /**
         * Error Message
         * @param msg String
         */
        public MoreThanExpectedException(String msg) {
            super(msg);
        }
    }
}