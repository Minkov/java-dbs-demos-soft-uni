package entities;

import utils.ToStringExtensions;

import javax.persistence.*;

@Entity(name = "people")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person implements ToStringExtensions {
    private int id;
    private String name;
    private int age;
    private Mother mother;

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

    @OneToOne(mappedBy = "child", targetEntity = Mother.class)
    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        return toString(this.getClass());
    }
}
