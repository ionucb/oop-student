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

        Faculty newFaculty = new Faculty(facultyAbbreviation, facultyAbbreviation, field, null);
        this.faculties.add(newFaculty);
    }

}