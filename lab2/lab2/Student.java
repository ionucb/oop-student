package lab2;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private Date enrollmentDate;
    private Date dateOfBirth;

    public Student(String firstName, String lastName, String email, Date enrollmentDate, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Date getEnrollmentDate() {

        return enrollmentDate;
    }

    public Date getDateOfBirth() {

        return dateOfBirth;
    }

    

}