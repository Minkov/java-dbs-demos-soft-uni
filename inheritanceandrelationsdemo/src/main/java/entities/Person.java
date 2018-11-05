package entities;

import javax.persistence.*;

@Entity(name = "people")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    private int id;
    private String name;
    private int age;

    public Person() {

    }

    public Person(String name) {
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

    @Column(
            length = 50,
            nullable = false,
            unique = true
    )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
