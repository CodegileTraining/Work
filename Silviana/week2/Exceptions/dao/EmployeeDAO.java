package com.example.dao;

import com.example.model.Employee;
import com.example.test.EmployeeNotFoundException;

public interface EmployeeDAO {

    public void add(Employee emp);

    public void update(Employee emp);

    public void delete(int id);

    public Employee findById(int id) throws EmployeeNotFoundException;

    public Employee[] getAllEmployees();
    
}