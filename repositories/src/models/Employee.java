package models;

public class Employee {
    private long id;
    private String firstName;
    private String lastName;

    public Employee() {

    }

    public Employee(String firstName, String lastName) {
        this(0, firstName, lastName);
    }

    public Employee(long id, String firstName, String lastName) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
