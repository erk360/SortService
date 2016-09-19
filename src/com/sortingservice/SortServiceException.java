package com.sortingservice;
/* 	
* 	Sort Service 1.0
*	Created 18/09/2016
*	By Erick Rafael
*/

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
