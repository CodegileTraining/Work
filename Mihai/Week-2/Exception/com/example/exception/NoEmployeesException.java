package com.example.exception;

/**
 * Class that treats the exception when there are no employees left.
 */
public class NoEmployeesException extends EmployeeException {
    /**
     * Constructor that calls the construct from the super class.
     */
    public NoEmployeesException() {

        super("No Employees ");
    }
}
