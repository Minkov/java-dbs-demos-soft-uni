import entities.Person;
import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        Person[] people =
                {
                        new Student("Pesho", 3),
                        new Teacher("Gosho", "Java")
                };

        entityManager.getTransaction().begin();

        Arrays.stream(people)
                .forEach(entityManager::persist);

        entityManager.getTransaction().commit();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Teacher> criteriaQuery =
                builder.createQuery(Teacher.class);

        criteriaQuery.from(Teacher.class);

        entityManager.createQuery(criteriaQuery)
                .getResultList()
                .forEach(System.out::println);
    }
}
