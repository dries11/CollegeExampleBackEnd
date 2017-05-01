package ries.dan.Entity;

import java.util.ArrayList;

/**
 * Created by danries on 4/29/17.
 */
public class StudentStatistics {

    private Integer totalStudents;
    private Integer activeStudents;
    private Integer inactiveStudents;
    private Integer male;
    private Integer female;

    public StudentStatistics(){
        this.totalStudents = 0;
        this.activeStudents = 0;
        this.inactiveStudents = 0;
        this.male = 0;
        this.female = 0;
    }

    public void generateStatistics(ArrayList<Student> students){
        this.totalStudents = students.size();
        for(Student student: students){
            if (student.getEnrolled().equals("yes")){
                this.activeStudents++;
            }
            else if(student.getEnrolled().equals("no")){
                this.inactiveStudents++;
            }
            if (student.getGender().equals("M")){
                this.male++;
            }
            else if(student.getGender().equals("F")){
                this.female++;
            }
        }
    }

    public Integer getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(Integer totalStudents) {
        this.totalStudents = totalStudents;
    }

    public Integer getActiveStudents() {
        return activeStudents;
    }

    public void setActiveStudents(Integer activeStudents) {
        this.activeStudents = activeStudents;
    }

    public Integer getInactiveStudents() {
        return inactiveStudents;
    }

    public void setInactiveStudents(Integer inactiveStudents) {
        this.inactiveStudents = inactiveStudents;
    }

    public Integer getMale() {
        return male;
    }

    public void setMale(Integer male) {
        this.male = male;
    }

    public Integer getFemale() {
        return female;
    }

    public void setFemale(Integer female) {
        this.female = female;
    }
}
