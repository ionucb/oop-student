package lab2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Faculty implements Serializable {

    private static final long serialVersionUID = 1L;

    private String abbreviation;
    private List<Student> students;
    private StudyField studyField;
    private List<Student> graduateStudents;

    public Faculty(String abbreviation, StudyField studyField) {
        this.abbreviation = abbreviation;
        this.students = new ArrayList<>();
        this.studyField = studyField;
        this.graduateStudents = new ArrayList<>();

    }

    public void enrollStudent(Student student) {

        students.add(student);
    }

    public void graduateStudent(Student student) {

        students.remove(student);
        graduateStudents.add(student);
    }

    public List<Student> getGraduateStudents() {

        return graduateStudents;
    }

    public void displayCurrentStudents() {

        System.out.println("Currently Enrolled Students in " + abbreviation + ": ");

        for (Student student : students) {

            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
    }

    public void displayGraduates(List<Student> allStudents) {

        System.out.println("Graduated Students from " + abbreviation + ":");

        for (Student student : allStudents) {
            if (!students.contains(student)) {

                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        }
    }

    public boolean isStudentInFaculty(String uniqueId) {

        for (Student student : students) {
            if (student.getUniqueId().equals(uniqueId)) {

                return true;
            }
        }
        return false;
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

    public Student findStudentByUniqueId(String uniqueId) {
        for (Student student : students) {
            if (student.getUniqueId().equals(uniqueId)) {
                return student;
            }
        }
        return null;
    }
}