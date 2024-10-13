package lab2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Faculty implements Serializable{

    private String name;
    private String abbreviation;
    private List<Student> students;
    private StudyField StudyField;

    public Faculty(String name, String abbreviation, StudyField StudyField, List<Student> students){
        this.name = name;
        this.abbreviation = abbreviation;
        this.StudyField = StudyField;
        this.students = new ArrayList<>();
    }

}