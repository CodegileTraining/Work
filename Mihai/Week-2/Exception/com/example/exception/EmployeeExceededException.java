package com.example.exception;

/**
 * Class that treats exception when there are no more space for employees to be added.
 */

public class EmployeeExceededException extends EmployeeException{

    /**
     * The constructor calls for the base class constructor to display the error message.
     */
    public EmployeeExceededException() {
        super("Limit reached");
    }
}
