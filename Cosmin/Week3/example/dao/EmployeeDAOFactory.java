package Week3.ExceptionsCodegile.src.com.example.dao;

public class EmployeeDAOFactory {

	public EmployeeDAO createEmployeeDAO() {

		return new EmployeeDAOMemoryImpl();

	}
}