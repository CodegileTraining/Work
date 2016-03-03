package com.example.exception;

/**
 * Class that treats the exception when an ID for an employee is invalid.
 */
public class InvalidIdException extends EmployeeException{

    /**
     * Calls the constructor in the superclass.
     */
    public InvalidIdException() {
        super("Invalid ID ");
    }
}
