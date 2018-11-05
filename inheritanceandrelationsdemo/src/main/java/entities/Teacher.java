package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "teachers")
public class Teacher extends Person {
    private String speciality;
    private boolean isKlasen;

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

    public boolean isKlasen() {
        return isKlasen;
    }

    public void setKlasen(boolean klasen) {
        isKlasen = klasen;
    }
}
