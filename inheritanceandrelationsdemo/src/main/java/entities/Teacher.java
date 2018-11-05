package entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "teachers")
public class Teacher extends Person {
    private String speciality;

    public Teacher() {

    }

    public Teacher(String name, String speciality) {
        super(name);
        setSpeciality(speciality);
    }

    @Column
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
