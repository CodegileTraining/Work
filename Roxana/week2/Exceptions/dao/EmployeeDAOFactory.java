package dao;

public class EmployeeDAOFactory {
/**
 * 
 * @return
 */
    public EmployeeDAO createEmployeeDAO() {
        return new EmployeeDAOMemoryImpl();
    }
}