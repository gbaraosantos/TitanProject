package com.baronhub.titan.project.common.exceptions;

/**
 * Database Exceptions
 */

public class DatabaseException {

    /**
     * In case a query returns zero objects
     */
    public static class NoElements extends BaseException {
        public NoElements(String msg) {
            super(msg);
        }
    }

    /**
     * More elements than expected
     */
    public static class MoreThanExpected extends BaseException {
        public MoreThanExpected(String msg) {
            super(msg);
        }
    }
}