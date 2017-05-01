package ries.dan;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ries.dan.Dao.StudentRepository;
import ries.dan.Entity.Student;
import ries.dan.Entity.StudentStatistics;
import ries.dan.Services.StudentServiceImpl;

import java.util.ArrayList;
import java.lang.*;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by danries on 4/13/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceTest {

    StudentStatistics expected;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Before
    public void initializationOfMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void initializeExpectedStatistics(){
        expected = new StudentStatistics();
        expected.setActiveStudents(2);
        expected.setFemale(2);
        expected.setInactiveStudents(1);
        expected.setMale(1);
        expected.setTotalStudents(3);
    }

    @Test
    public void testCreatingAStudent(){
        Student student = new Student();
        student.setFirstName("Someone");
        student.setLastName("Someone");
        when(studentRepository.save(student)).thenReturn(student);

        Student result = studentService.createNewStudent(student);

        assertTrue(result.getFirstName().equals("Someone"));
        assertTrue(result.getLastName().equals("Someone"));
    }

    @Test
    public void testGetAllStudent(){
        ArrayList<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student());
        studentsList.add(new Student());
        studentsList.add(new Student());
        when(studentRepository.findAll()).thenReturn(studentsList);

        ArrayList<Student> results = studentService.getAllStudents();
        assertTrue(results.size() == 3);
    }

    @Test
    public void testUnEnrollment(){
        Student student = new Student();
        student.setEnrolled("yes");
        when(studentRepository.findOne(1)).thenReturn(student);

        String result = studentService.studentLeavesSchool(1);
        assertTrue(result.equals("Un-Enrolled Student"));
    }

    @Test
    public void testGetHeadCount(){
        studentRepository.save(new Student());
        studentRepository.save(new Student());
        when(studentRepository.count()).thenReturn(2L);

        Long result = studentService.getHeadCount();
        Long expected = 2L;
        assertEquals(expected,result);
    }

    @Test
    public void testStatistics(){
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        student1.setGender("M");
        student1.setEnrolled("yes");
        student2.setGender("F");
        student2.setEnrolled("no");
        student3.setGender("F");
        student3.setEnrolled("yes");
        ArrayList<Student> students = new ArrayList<>();
        students.add(student1); students.add(student2); students.add(student3);
        StudentStatistics actual = studentService.getStatistics(students);
        assertTrue(expected.getTotalStudents() == actual.getTotalStudents());
        assertTrue(expected.getActiveStudents() == actual.getActiveStudents());
        assertTrue(expected.getFemale() == actual.getFemale());
        assertTrue(expected.getInactiveStudents() == actual.getInactiveStudents());
        assertTrue(expected.getMale() == actual.getMale());
    }

}
