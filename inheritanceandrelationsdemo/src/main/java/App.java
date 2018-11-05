import entities.Department;
import entities.Employee;
import entities.Person;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();
//
//        Department department = new Department("Engineering");
//
//        Employee employee = new Employee("Pesho", new Date());
//        employee.setDepartment(department);
//
//        inTransaction(
//                entityManager,
//                () -> entityManager.persist(employee)
//        );

        Project project = entityManager.find(Project.class, 36);
        System.out.println(project.employees);
        System.out.println(" --- -- -- -- ");
        project.getEmployees()
                .forEach(System.out::println);
    }

    static void inTransaction(EntityManager entityManager, Runnable runnable) {
        entityManager.getTransaction().begin();
        runnable.run();
        entityManager.getTransaction().commit();
    }
}
