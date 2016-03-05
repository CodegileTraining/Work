package com.example.model;
/**
 * The Employee class implements the basic data for an employee
 */

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private float salary;

    /**
     * Empty constructor because why not.
     */
    public Employee() {
    }

    /**
     * Constructor for the Employee class that initialize the Employee objects
     * @param id is th ID for the employee type int
     * @param firstName is the first name of the employee type String
     * @param lastName is the last name of the employee type String
     * @param birthDate is the birth date of the employee type Date
     * @param salary is the salary of the employee type float
     */
    public Employee(int id, String firstName, String lastName, Date birthDate, float salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    /**
     * Method to get the id of the employee
     * @return the id of the employee as an int
     */
    public int getId() {
        return id;
    }

    /**
     * Method to get the first name of the employee
     * @return the first name of the employee as a String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method to get the last name of the employee
     * @return the last name of the employee as a String
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Method to get the Birth date of the employee
     * @return the Birth date of the employee as a Date
     */
    public Date getBirthDate() {
        return birthDate;
    }
    /**
     * Method to get the salary of the employee
     * @return the last name of the employee as a float
     */
    public float getSalary() {
        return salary;
    }

    /**
     * Override the toString method from Object
     * @return the details of the employee as a string
     */
    @Override
    public String toString() {
        return "Employee ID:   " + getId() + "\n"
                + "Employee Name: " + getFirstName() + " " + getLastName() + "\n"
                + "Birth Date:    " + new SimpleDateFormat("MMM d, yyyy").format(getBirthDate()) + "\n"
                + "Salary:        " + NumberFormat.getCurrencyInstance().format((double) getSalary());
    }
}
