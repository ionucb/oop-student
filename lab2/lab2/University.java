package lab2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class University implements Serializable {

    private static final long serialVersionUID = 1L;

    private transient List<Faculty> faculties;

    public University() {
        faculties = new ArrayList<>();
    }

    public void createFaculty(String facultyName, String facultyAbbreviation, StudyField field) {

        Faculty newFaculty = new Faculty(facultyAbbreviation, field);
        faculties.add(newFaculty);
    }

    public Faculty findFacultyForStudent(String uniqueIdentifier) {

        for (Faculty faculty : faculties) {
            for (Student student : faculty.getStudents()) {

                if (student.getEmail().equals(uniqueIdentifier) || student.getUniqueId().equals(uniqueIdentifier)) {

                    return faculty;
                }
            }
        }
        return null;
    }

    public void displayFaculties() {

        System.out.println("University Faculties:");
        for (Faculty faculty : faculties) {

            System.out.println(
                    "Abbreviation: " + faculty.getAbbreviation() + ", Study Field: " + faculty.getStudyField());
        }
    }

    public void displayFacultiesByField(StudyField studyField) {

        System.out.println("Faculties in " + studyField + ":");

        for (Faculty faculty : faculties) {

            if (faculty.getStudyField() == studyField) {
                System.out.println("Abbreviation: " + faculty.getAbbreviation());
            }
        }
    }

    public Faculty findFacultyByAbbreviation(String abbreviation) {

        if (abbreviation != null) {
            for (Faculty faculty : faculties) {
                if (faculty.getAbbreviation().equals(abbreviation)) {

                    return faculty;
                }
            }
        }
        return null;
    }

}