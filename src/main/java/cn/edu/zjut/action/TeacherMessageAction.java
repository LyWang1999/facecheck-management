package cn.edu.zjut.action;

import cn.edu.zjut.po.Teacher;
import cn.edu.zjut.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("prototype")
@Controller
public class TeacherMessageAction {
    private Integer teaID;
    private Teacher teacher;
    @Autowired
    private ITeacherService teacherService;

    public Integer getTeaID() {
        return teaID;
    }

    public void setTeaID(Integer teaID) {
        this.teaID = teaID;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * 传入教师的ID，返回教师信息
     */
    public String getTeaMess() {
        try {
            System.out.println("正在执行TeacherMessageAction的getTeaMess方法...");
            teacher = (Teacher) teacherService.getTeacherByID(teaID);
            if (teacher != null)
                return "getTeaMessSuccess";
            else
                return "getTeaMessFail";
        } catch (Exception e) {
            return "login";
        }
    }

    /**
     * 传入学生ID，返回学生的信息
     */
    public String updateTeaMess() {
        try {
            System.out.println("正在执行TeacherMessageAction的updateTeaMess方法...");
            if (teacherService.updateTeacher(teacher))
                return "updateTeaMessSuccess";
            else
                return "updateTeaMessFail";
        } catch (Exception e) {
            return "login";
        }
    }

    /**
     * 传入教师的ID，删除教师信息
     */
    public String deleteTeaMess() {
        try {
            System.out.println("正在执行TeacherMessageAction的deleteTeaMess方法...");
            if (teacherService.deleteTeacher(teaID))
                return "deleteTeaMessSuccess";
            else
                return "deleteTeaMessFail";
        } catch (Exception e) {
            return "login";
        }
    }
}