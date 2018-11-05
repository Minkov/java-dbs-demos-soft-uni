package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "employees")
public class Employee extends Person {
    private Date hireDate;
    private Department department;
    private Set<Project> projects;

    public Employee() {

    }

    public Employee(String name, Date hireDate) {
        super(name);
        setHireDate(hireDate);
    }

    @Column(name = "hire_date")
    public Date getHireDate() {
        return hireDate;
    }


    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToMany(
            mappedBy = "employees",
            targetEntity = Project.class,
            fetch = FetchType.LAZY
    )
    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
