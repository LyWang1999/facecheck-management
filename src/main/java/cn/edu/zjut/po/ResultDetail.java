package cn.edu.zjut.po;

public class ResultDetail {
    StudentSign studentsign;//学生打卡结果
    String student_name;//学生姓名
    String student_class;//班级名
    String student_department;//专业名

    public void setStudentsign(StudentSign studentsign) {
        this.studentsign = studentsign;
    }

    public StudentSign getStudentsign() {
        return studentsign;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_department(String student_department) {
        this.student_department = student_department;
    }

    public String getStudent_department() {
        return student_department;
    }

    @Override
    public String toString() {
        return "ResultDetail{" +
                "studentsign=" + studentsign +
                ", student_name='" + student_name + '\'' +
                ", student_class='" + student_class + '\'' +
                ", student_department='" + student_department + '\'' +
                '}';
    }
}
