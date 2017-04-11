package ries.dan.Entity;

import javax.persistence.*;

/**
 * Created by danries on 4/11/17.
 */
@Entity(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseId;

    private String name;
    private int credits;
    private int capacity;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
