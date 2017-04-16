package ries.dan;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ries.dan.Dao.StudentRepository;
import ries.dan.Entity.Student;
import ries.dan.Services.StudentServiceImpl;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by danries on 4/13/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Before
    public void initializationOfMocks(){
        MockitoAnnotations.initMocks(this);
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

}
