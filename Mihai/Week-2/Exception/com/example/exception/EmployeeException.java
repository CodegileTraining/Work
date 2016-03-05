package com.example.exception;

/**
 * Created by Mihai on 02.03.2016.
 */

/**
 *Base class for all exception written by the programmer.
 */
public class EmployeeException extends Exception {
    /**
     *  Calls the constructor from the base class Exception to display the error message.
     * @param e a string used to display the error message
     */
    public EmployeeException(String e){
        super(e);
    }
}
