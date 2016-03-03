package com.example.exception;

/**
 * Class that treats the exception when one id is taken.
 */
public class EmployeeIDTaken extends EmployeeException {
    /**
     * Constructor that calls the constructor from the super class.
     */
    public EmployeeIDTaken() {
        super("Id already taken");
    }
}
