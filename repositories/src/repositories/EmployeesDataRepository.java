package repositories;

import models.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeesDataRepository extends JdbcDataRepository<Employee> {
    public EmployeesDataRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected List<String> getValues(Employee object) {
        return List.of(object.getFirstName(), object.getLastName());
    }

    @Override
    protected String getColumns() {
        return "first_name, last_name";
    }

    @Override
    protected Employee parseRow(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        return new Employee(id, firstName, lastName);
    }

    @Override
    protected String getTableName() {
        return "employees";
    }
}
