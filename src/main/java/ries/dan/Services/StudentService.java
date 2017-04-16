package ries.dan.Services;

import ries.dan.Entity.Student;

import java.util.ArrayList;

/**
 * Created by danries on 4/13/17.
 */
public interface StudentService {

    Student createNewStudent(Student student);

    ArrayList<Student> getAllStudents();

    String studentLeavesSchool(Integer id);

    Long getHeadCount();


}
