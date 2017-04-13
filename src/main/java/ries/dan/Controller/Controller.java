package ries.dan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ries.dan.Entity.Student;
import ries.dan.Dao.StudentRepository;

import java.util.ArrayList;

/**
 * Created by danries on 4/6/17.
 */
@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping(path = "/students")
public class Controller {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody String addNewUser(@RequestBody Student student){
        studentRepository.save(student);
        return "Saved";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public ArrayList<Student> getAllUsers(){
        ArrayList students;
        students = (ArrayList) studentRepository.findAll();
        return students;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String deleteUser(@RequestBody Integer id){
        if (studentRepository.exists(id)){
            Student student = studentRepository.findOne(id);
            student.setEnrolled("no");
            studentRepository.save(student);
        }
        return "Removed";
    }

    @RequestMapping(value = "/headCount", method = RequestMethod.GET)
    public long getHeadCount(){
        return studentRepository.count();
    }
}
