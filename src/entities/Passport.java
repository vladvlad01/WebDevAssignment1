package entities;

import javax.persistence.*;
import javax.persistence.Entity;

@NamedQueries({
        @NamedQuery(name = "Passport.findAll",                  query = "select p from Passport p"),
        @NamedQuery(name = "Passport.findByPassportNumber",     query = "select p from Passport p where p.passportNumber = :passportNumber"),
        @NamedQuery(name = "Passport.findAllOrderedByLastName", query = "SELECT p FROM Passport p ORDER BY p.lastName")
})

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String nationality;
    private String passportNumber;

    public Passport(){}

    public Passport(String firstName, String lastName, String nationality, String passportNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.passportNumber = passportNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }
}
