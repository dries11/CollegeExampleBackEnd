package ries.dan.Dao;

import org.springframework.data.repository.CrudRepository;
import ries.dan.Entity.Student;

/**
 * Created by danries on 4/6/17.
 */
public interface StudentRepository extends CrudRepository<Student, Integer>{
}
