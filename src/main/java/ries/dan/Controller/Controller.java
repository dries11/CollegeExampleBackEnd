package ries.dan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ries.dan.Entity.Student;
import ries.dan.Dao.StudentRepository;
import ries.dan.Services.StudentServiceImpl;

import java.util.ArrayList;

/**
 * Created by danries on 4/6/17.
 */
@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping(path = "/students")
public class Controller {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody Object addNewUser(@RequestBody Student student){
        Student response = this.studentServiceImpl.createNewStudent(student);
        return response;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public ArrayList<Student> getAllUsers(){
        return this.studentServiceImpl.getAllStudents();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String deleteUser(@RequestBody Integer id){
        String response = this.studentServiceImpl.studentLeavesSchool(id);
        return response;
    }

    @RequestMapping(value = "/headCount", method = RequestMethod.GET)
    public long getHeadCount(){
        return this.studentServiceImpl.getHeadCount();
    }

}
