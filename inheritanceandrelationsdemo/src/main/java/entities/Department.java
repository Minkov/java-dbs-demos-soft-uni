package entities;

import utils.ToStringExtensions;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "departments")
public class Department implements ToStringExtensions {
    private int id;
    private String name;
    Set<Employee> employees;

    public Department() {

    }

    public Department(String name) {
        setName(name);
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "department", targetEntity = Employee.class)
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return toString(this.getClass());
    }
}
