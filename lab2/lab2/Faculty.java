package lab2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Faculty implements Serializable {

    private String name;
    private String abbreviation;
    private List<Student> students;
    private StudyField studyField;

    public Faculty(String name, String abbreviation, StudyField studyField, List<Student> students) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.studyField = studyField;
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student) {

        students.add(student);
    }

    public void displayCurrentStudents() {

        System.out.println("Currently Enrolled Students in " + abbreviation + ": ");

        for (Student student : students) {

            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
    }

    public String getName() {

        return name;
    }

    public List<Student> getStudents() {

        return students;
    }

    public String getAbbreviation() {

        return abbreviation;
    }

    public StudyField getStudyField() {

        return studyField;
    }
}