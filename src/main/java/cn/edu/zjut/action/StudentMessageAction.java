package cn.edu.zjut.action;

import cn.edu.zjut.po.Student;
import cn.edu.zjut.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class StudentMessageAction {
    private Integer stuID;
    private Student student;
    
    @Autowired
    private IStudentService studentService;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getStuID() {
        return stuID;
    }

    public void setStuID(Integer stuID) {
        this.stuID = stuID;
    }

    /**
     * 传入学生ID，返回学生的信息
     */
    public String getStuMess() {
        System.out.println("正在执行StudentMessageAction的getStuMess方法...");
        try {
            if (studentService.showStudent(stuID))
                return "getStuMessSuccess";
            else
                return "getStuMessFail";
        } catch (Exception e) {
            return "login";
        }
    }

    /**
     * 传入一个学生的新的信息，并更新
     */
    public String updateStuMess() {
        System.out.println("正在执行StudentMessageAction的updateStuMess方法...");
        try {
            if (studentService.updateStudent(student))
                return "updateStuMessSuccess";
            else
                return "updateStuMessFail";
        } catch (Exception e) {
            return "login";
        }
    }

    /**
     * 传入一个学生ID，调用删除学生的方法
     */
    public String deleteStuMess() {
        System.out.println("正在执行StudentMessageAction的deleteStuMess方法...");
        try {
            if (studentService.deleteStudent(stuID))
                return "deleteStuMessSuccess";
            else
                return "deleteStuMessFail";
        } catch (Exception e) {
            return "login";

        }
    }
}
