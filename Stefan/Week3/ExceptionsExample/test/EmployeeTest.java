

package com.example.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.model.Employee;
import com.example.dao.EmployeeDAOFactory;
import com.example.exceptions.MyException;
import com.example.exceptions.ValidFirstName;
import com.example.exceptions.ValidLastName;
import com.example.exceptions.ValidPositiveID;
import com.example.exceptions.ValidSalary;
import com.example.dao.EmployeeDAO;
import java.util.Date;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * Class that contains main method
 * @author Stefan
 *
 */
public class EmployeeTest {

    public static void main(String[] args) throws Exception {
        EmployeeDAOFactory factory = new EmployeeDAOFactory();

        boolean timeToQuit = false;

        EmployeeDAO dao = factory.createEmployeeDAO();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
        	try{
            timeToQuit = executeMenu(in, dao);
        	}
        	catch(ValidPositiveID e){
        		e.printStackTrace();
        	}
        	catch(ValidFirstName e){
        		e.printStackTrace();
        	}
        	catch(ValidLastName e){
        		e.printStackTrace();
        	}
        	catch(ValidSalary e){
        		e.printStackTrace();
        	}
        	catch(ArrayIndexOutOfBoundsException e){
        		e.printStackTrace();
        	}
        } while (!timeToQuit);
    }
/**
 * Print on Console all the options the user has to continue +
 * Resolves each case :
 * C : reads data for a new employee and adds him to the employee list from EmployeeDAO parameter
 * R : reads an id and prints the employee with that id if exists
 * U : updates an employee
 * D : delete an employee
 * L : prints all employees 
 * Q : quit
 * @param in : BufferedReader;
 * @param dao : EmployeeDAO
 * @return
 * @throws IOException
 * @throws MyException
 * @throws ArrayIndexOutOfBoundsException
 */
    public static boolean executeMenu(BufferedReader in, EmployeeDAO dao) throws IOException, MyException,ArrayIndexOutOfBoundsException {
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
                dao.add(emp);
                System.out.println("Successfully added Employee Record: " + emp.getId());
                System.out.println("\n\nCreated " + emp);
                break;

            // Display an employee record
            case 'R':
                System.out.println("Enter int value for employee id: ");
                id = new Integer(in.readLine().trim());

                // Find this Employee record
                emp = dao.findById(id);
                if (emp != null) {
                    System.out.println(emp + "\n");
                } else {
                    System.out.println("\n\nEmployee " + id + " not found");
                    break;
                }

                break;

            // Update an existing employee record    
            case 'U':
                System.out.println("Enter int value for employee id: ");
                id = new Integer(in.readLine().trim());
                // Find this Employee record
                emp = null;
                emp = dao.findById(id);
                if (emp == null) {
                    System.out.println("\n\nEmployee " + id + " not found");
                    break;
                }
                // Go through the record to allow changes

                emp = inputEmployee(in, emp);
                dao.update(emp);
                System.out.println("Successfully updated Employee Record: " + emp.getId());
                break;

            // Delete an employee record
            case 'D':
                System.out.println("Enter int value for employee id: ");
                id = new Integer(in.readLine().trim());

                // Find this Employee record                 
                dao.delete(id);
                System.out.println("Deleted Employee " + id);
                break;

            // Display a list (Read the records) of Employees
            case 'L':
                Employee[] allEmps = dao.getAllEmployees();
                for (Employee employee : allEmps) {
                    System.out.println(employee + "\n");
                }
                break;
        }

        return false;
    }

    public static Employee inputEmployee(BufferedReader in) throws IOException, MyException {
        return inputEmployee(in, null, true);
    }

    public static Employee inputEmployee(BufferedReader in, Employee empDefaults) throws IOException, MyException {
        return inputEmployee(in, empDefaults, false);
    }
/**
 * Creates and returns a new Employee type object
 * @param in
 * @param empDefaults
 * @param newEmployee
 * @return
 * @throws IOException
 * @throws MyException
 */
    public static Employee inputEmployee(BufferedReader in, Employee empDefaults, boolean newEmployee) throws IOException, MyException {
        SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy");
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        int id = -1;
        String firstName;
        String lastName;
        Date birthDate = null;
        Employee emp;
        float salary;

        if (newEmployee) {
            do {
                System.out.println("Enter int value for employee id: ");
                try {
                    id = new Integer(in.readLine().trim());
                    if (id < 0) {
                        System.out.println("Please retry with a valid positive integer id");
                        throw new ValidPositiveID("Id negativ");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please retry with a valid positive integer id");
                }
            } while (id < 0);
        } else {
            id = empDefaults.getId();
            System.out.println("Modify the fields of Employee record: " + id
                    + ". Press return to accept current value.");
        }

        String prompt = "Enter value for employee first name" + ((empDefaults == null) ? "" : " [" + empDefaults.getFirstName() + "]");

        do {
            System.out.println(prompt + " : ");
            firstName = in.readLine().trim();
            if (firstName.equals("") && empDefaults != null) {
                firstName = empDefaults.getFirstName();
            }
            if (firstName.length() < 1) {
                System.out.println("Please retry with a valid first name");
                throw new ValidFirstName("Invalid First Name");
            }
        } while (firstName.length() < 1);


        prompt = "Enter value for employee last name" + ((empDefaults == null) ? "" : " [" + empDefaults.getLastName() + "]");
        do {
            System.out.println(prompt + " : ");
            lastName = in.readLine().trim();
            if (lastName.equals("") && empDefaults != null) {
                lastName = empDefaults.getLastName();
            }
            if (lastName.length() < 1) {
                System.out.println("Please retry with a valid last name");
                throw new ValidLastName("Invalid Last Name");
            }
        } while (lastName.length() < 1);


        prompt = "Enter value for employee birth date (" + df.toLocalizedPattern() + ")"
                + ((empDefaults == null) ? "" : " [" + df.format(empDefaults.getBirthDate()) + "]");
        do {
            System.out.println(prompt + " : ");
            String dateStr = in.readLine().trim();
            if (dateStr.equals("") && empDefaults != null) {
                birthDate = empDefaults.getBirthDate();
            } else {
                birthDate = null;
                try {
                    birthDate = new Date(df.parse(dateStr).getTime());
                } catch (ParseException e) {
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
                    throw new ValidSalary("Negative Salary");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please retry with a valid float salary: " + e.getMessage());
            }
        } while (salary == 0);

        // Create an Employee object
        emp = new Employee(id, firstName, lastName, birthDate, salary);
        return emp;
    }
}