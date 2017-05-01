package ries.dan.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ries.dan.Dao.StudentRepository;
import ries.dan.Entity.Student;
import ries.dan.Entity.StudentStatistics;

import java.util.ArrayList;

/**
 * Created by danries on 4/13/17.
 */
@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private StudentStatistics studentStatistics;

    @Override
    public Student createNewStudent(Student student) {
        student.setEnrolled("yes");
        return this.studentRepository.save(student);
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        return (ArrayList<Student>) this.studentRepository.findAll();
    }

    @Override
    public String studentLeavesSchool(Integer id) {
        Student toUnEnroll = this.studentRepository.findOne(id);
        toUnEnroll.setEnrolled("no");
        this.studentRepository.save(toUnEnroll);
        return "Un-Enrolled Student";
    }

    @Override
    public Long getHeadCount() {
        return this.studentRepository.count();
    }

    @Override
    public StudentStatistics getStatistics(ArrayList<Student> students){
        studentStatistics = new StudentStatistics();
        this.studentStatistics.generateStatistics(students);
        return this.studentStatistics;
    }

}
