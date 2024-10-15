package lab2;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private Date enrollmentDate;
    private Date dateOfBirth;
    private String uniqueId;

    public Student(String firstName, String lastName, String email, Date enrollmentDate, Date dateOfBirth, String uniqueId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.dateOfBirth = dateOfBirth;
        this.uniqueId = uniqueId;
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

    public String getUniqueId() {
        return uniqueId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}