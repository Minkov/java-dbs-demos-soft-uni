import entities.Employee;
import repositories.JpaDataRepository;
import repositories.base.DataRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        DataRepository<Employee> employeeData
                = getEmployeesData();

        employeeData.listAll()
                .forEach(System.out::println);

        employeeData.add(new Employee("John", "Doe"));
        int id = 18;

        Employee employee = employeeData.find(id);
        System.out.println(employee);
        employee.setFirstName(employee.getFirstName() + " NEW ");
        employeeData.update(employee);

        employee = employeeData.find(id);
        System.out.println(employee);
        employeeData.delete(employee);
        employee = employeeData.find(id);
        System.out.println(employee);
    }

    private static DataRepository<Employee> getEmployeesData() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("soft_uni_simple");
        return new JpaDataRepository<>(emf, Employee.class);

//
//            Configuration config = new Configuration()
//                .configure();
//
//            config.addAnnotatedClass(Employee.class);
//
//            SessionFactory sessionFactory =
//                    config.buildSessionFactory();
//
//
//
//            return new HibernateDataRepository<>(sessionFactory, Employee.class);
    }
}
