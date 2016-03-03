package com.example.exception;

/**
 * Class that treats the exception when a name of an employee is invalid
 */
public class EmployeeInvalidNameException extends EmployeeException {

    /**
     * Calls the constructor of the base class to display the error message
     */
    public EmployeeInvalidNameException() {
        super("Invalid Name");
    }
}
