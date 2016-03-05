package com.example.dao;


public class EmployeeDAOFactory {
    /**
     *
     * @return an object of type EmployeeDAOMemoryImpl
     */
    public EmployeeDAO createEmployeeDAO() {
        return new EmployeeDAOMemoryImpl();
    }
}