package com.sortingservice;

public class SortServiceException extends Exception {
    public SortServiceException () {

    }

    public SortServiceException (String message) {
        super (message);
    }

    public SortServiceException (Throwable cause) {
        super (cause);
    }

    public SortServiceException (String message, Throwable cause) {
        super (message, cause);
    }
}
