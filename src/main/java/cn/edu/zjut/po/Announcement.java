package cn.edu.zjut.po;

public class Announcement {
    String title;
    String describe;
    Teacher teacher;
    Student student;
    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }
    public void setDescribe(String describe){
        this.describe=describe;
    }
    public String getDescribe(){
        return describe;
    }
    public void setTeacher(Teacher teacher){
    this.teacher=teacher;
    }
    public Teacher getTeacher(){
        return teacher;
    }
    public void setStudent(Student student){
        this.student=student;
    }
    public Student getStudent(){
        return student;
    }
}
