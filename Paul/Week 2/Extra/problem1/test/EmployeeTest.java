package com.codegile.week2.extra.problem1.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.codegile.week2.extra.problem1.dao.EmployeeDAO;
import com.codegile.week2.extra.problem1.dao.EmployeeDAOFactory;
import com.codegile.week2.extra.problem1.exceptions.*;
import com.codegile.week2.extra.problem1.model.Employee;

import java.util.Date;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Testing environment for project classes.
 */
public class EmployeeTest {

  /**
   * Program entry point.
   * 
   * @param args
   * @throws Exception Routed IOExceptions from read methods.
   */
  public static void main(String[] args) throws Exception {
    EmployeeDAOFactory factory = new EmployeeDAOFactory();
    EmployeeDAO dao = factory.createEmployeeDAO();
    boolean timeToQuit = false;

    dao.add(new Employee(1, "Paul", "Hristea", new Date(), 500));
    dao.add(new Employee(2, "Ana", "Popescu", new Date(), 200));
    dao.add(new Employee(3, "Dan", "Pomonos", new Date(), 300));
    // Uncomment for full database
    /*
     * dao.add(new Employee(4, "Paul", "Hristea", new Date(), 500)); dao.add(new Employee(5, "Ana", "Popescu", new
     * Date(), 200)); dao.add(new Employee(6, "Dan", "Pomonos", new Date(), 300)); dao.add(new Employee(7, "Paul",
     * "Hristea", new Date(), 500)); dao.add(new Employee(8, "Ana", "Popescu", new Date(), 200)); dao.add(new
     * Employee(9, "Dan", "Pomonos", new Date(), 300)); dao.add(new Employee(0, "Dan", "Pomonos", new Date(), 300));
     */

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    do {
      timeToQuit = executeMenu(in, dao);
    } while (!timeToQuit);
  }

  /**
   * Prints a simple text menu to the user, presenting data manipulation options and an exit choice. Returns false when
   * the exit choice is selected.
   * 
   * @param in Input source to use for data entry.
   * @param dao Data access object to manipulate data.
   * @return False when user chooses to quit.
   * @throws IOException Routed from read methods.
   */
  public static boolean executeMenu(BufferedReader in, EmployeeDAO dao) throws IOException {
    Employee emp;
    String action;
    int id;

    System.out.println("\n\n[C]reate | [R]ead | [U]pdate | [D]elete | [L]ist | [Q]uit: ");
    action = in.readLine();
    if ((action.length() == 0) || action.toUpperCase().charAt(0) == 'Q') {
      return true;
    }

    switch (action.toUpperCase().charAt(0)) {
    // Create a new employee record
    case 'C':
      emp = inputEmployee(in);
      try {
        dao.add(emp);
      }
      catch (EmployeeException e) {
        System.out.println(e.getMessage());
        break;
      }
      System.out.println("Successfully added Employee Record: " + emp.getId());
      System.out.println("\n\nCreated " + emp);
      break;

    // Display an employee record
    case 'R':
      id = readId(in);

      try {
        // Find this Employee record
        emp = dao.findById(id);
      }
      catch (EmployeeException e) {
        System.out.println(e.getMessage());
        break;
      }

      System.out.println(emp + "\n");
      break;

    // Update an existing employee record
    case 'U':
      id = readId(in);

      try {
        // Find this Employee record
        emp = dao.findById(id);
      }
      catch (EmployeeException e) {
        System.out.println(e.getMessage());
        break;
      }

      // Go through the record to allow changes
      emp = inputEmployee(in, emp);
      try {
        dao.update(emp);
      }
      catch (EmployeeException e) {
        System.out.println(e.getMessage());
        break;
      }
      System.out.println("Successfully updated Employee Record: " + emp.getId());
      break;

    // Delete an employee record
    case 'D':
      id = readId(in);

      try {
        // Find and delete this Employee record
        dao.delete(id);
      }
      catch (EmployeeException e) {
        System.out.println(e.getMessage());
        break;
      }
      System.out.println("Deleted Employee " + id);
      break;

    // Display a list (Read the records) of Employees
    case 'L':
      Employee[] allEmps;
      try {
        allEmps = dao.getAllEmployees();
      }
      catch (CapacityZeroException e) {
        System.out.println(e.getMessage());
        break;
      }
      for (Employee employee : allEmps) {
        System.out.println(employee + "\n");
      }
      break;
    }

    return false;
  }

  /**
   * Reads and returns a valid id for use in the program.
   * 
   * @param in Input source.
   * @return A valid id.
   * @throws IOException
   */
  public static int readId(BufferedReader in) throws IOException {
    int id;
    System.out.println("Enter int value for employee id: ");
    try {
      id = new Integer(in.readLine().trim());
      if (id < 0) {
        throw new NumberFormatException();
      }
    }
    catch (NumberFormatException e) {
      System.out.println("Please retry with a valid positive integer id");
      return readId(in);
    }
    return id;
  }

  /**
   * Reads data for, and returns, a new employee object.
   * 
   * @param in Input source.
   * @return A new employee object.
   * @throws IOException
   */
  public static Employee inputEmployee(BufferedReader in) throws IOException {
    return inputEmployee(in, null, true);
  }

  /**
   * Reads input for, and returns, a new employee object. Offers default value initialization as contained in the
   * provided existing employee object.
   * 
   * @param in Input source.
   * @param empDefaults Employee object containing default values for the one being created.
   * @return A new employee object.
   * @throws IOException
   */
  public static Employee inputEmployee(BufferedReader in, Employee empDefaults) throws IOException {
    return inputEmployee(in, empDefaults, false);
  }

  /**
   * If the boolean value provided in "newEmployee" equals true, this method reads input for, and returns, a new
   * Employee object. Optionally, default initialization values can be provided through a non-null Employee object. No
   * default values will be offered if the Employee object transmitted is null. If the boolean value is of false value,
   * the provided Employee default object must be non-null, and should contain an Employee object meant to be updated,
   * as the method will ask for new values (and offer to keep the old ones).
   * 
   * @param in Input source.
   * @param empDefaults Employee object to be updated or containing default values.
   * @param newEmployee True if a new employee is being created, false if existing one is being updated.
   * @return The new, or updated, employee object.
   * @throws IOException
   */
  public static Employee inputEmployee(BufferedReader in, Employee empDefaults, boolean newEmployee)
      throws IOException {
    SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy");
    NumberFormat nf = NumberFormat.getCurrencyInstance();
    int id;
    String firstName;
    String lastName;
    Date birthDate = null;
    Employee emp;
    float salary;

    if (newEmployee) {
      id = readId(in);
    }
    else {
      id = empDefaults.getId();
      System.out.println("Modify the fields of Employee record: " + id + ". Press return to keep current value.");
    }

    String prompt = "Enter value for employee first name"
        + ((empDefaults == null) ? "" : " [" + empDefaults.getFirstName() + "]");

    do {
      System.out.println(prompt + " : ");
      firstName = in.readLine().trim();
      if (firstName.equals("") && empDefaults != null) {
        firstName = empDefaults.getFirstName();
      }
      if (firstName.length() < 1) {
        System.out.println("Please retry with a valid first name");
      }
    } while (firstName.length() < 1);

    prompt = "Enter value for employee last name"
        + ((empDefaults == null) ? "" : " [" + empDefaults.getLastName() + "]");
    do {
      System.out.println(prompt + " : ");
      lastName = in.readLine().trim();
      if (lastName.equals("") && empDefaults != null) {
        lastName = empDefaults.getLastName();
      }
      if (lastName.length() < 1) {
        System.out.println("Please retry with a valid last name");
      }
    } while (lastName.length() < 1);

    prompt = "Enter value for employee birth date (" + df.toLocalizedPattern() + ")"
        + ((empDefaults == null) ? "" : " [" + df.format(empDefaults.getBirthDate()) + "]");
    do {
      System.out.println(prompt + " : ");
      String dateStr = in.readLine().trim();
      if (dateStr.equals("") && empDefaults != null) {
        birthDate = empDefaults.getBirthDate();
      }
      else {
        birthDate = null;
        try {
          birthDate = new Date(df.parse(dateStr).getTime());
        }
        catch (ParseException e) {
          System.out.println("Please retry with a valid birth date: " + e.getMessage());
        }
      }
    } while (birthDate == null);

    prompt = "Enter float value for employee salary"
        + ((empDefaults == null) ? "" : " [" + nf.format((double) empDefaults.getSalary()) + "]");
    do {
      System.out.println(prompt + " : ");
      salary = 0;
      try {
        String amt = in.readLine().trim();
        if (!amt.equals("")) {
          salary = Float.parseFloat(amt);
        }
        if (salary == 0 && empDefaults != null) {
          salary = empDefaults.getSalary();
        }
        if (salary < 0) {
          System.out.println("Please retry with a positive salary");
          salary = 0;
        }
      }
      catch (NumberFormatException e) {
        System.out.println("Please retry with a valid float salary: " + e.getMessage());
      }
    } while (salary == 0);

    // Create an Employee object
    emp = new Employee(id, firstName, lastName, birthDate, salary);
    return emp;
  }
}