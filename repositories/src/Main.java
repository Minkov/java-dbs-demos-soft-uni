import models.Employee;
import repositories.EmployeesDataRepository;
import repositories.base.DataRepository;

import java.sql.*;

public class Main {
    private static DataRepository<Employee> employeesData;
    private static final String CONNECTION_STRING = "jdbc:mysql://127.0.0.1:3306/soft_uni_simple";
    private static Connection connection;

    public static void main(String[] args) throws SQLException {
        DataRepository<Employee> employeeData = getEmployeesRepository();

        employeeData.getAll()
                .stream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);

        System.out.println("-----------------");
        employeeData.insert(new Employee("GOshi", "Oeshov"));

        employeeData.getAll()
                .stream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    private static DataRepository<Employee> getEmployeesRepository() throws SQLException {
        if (employeesData == null) {
            Connection connection = getConnection();
            employeesData = new EmployeesDataRepository(connection);
        }

        return employeesData;
    }

    private static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(CONNECTION_STRING, "root", "");
        }

        return connection;
    }
}
