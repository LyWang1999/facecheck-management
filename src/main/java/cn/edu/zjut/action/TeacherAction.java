package cn.edu.zjut.action;


import cn.edu.zjut.po.Sign;
import cn.edu.zjut.po.Teacher;
import cn.edu.zjut.service.IResultService;
import cn.edu.zjut.service.ITeacherService;
import cn.edu.zjut.service.ResultService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Scope("prototype")
@Controller
public class TeacherAction {
    private String searchMess;
    private int searchType;
    private Teacher teacher;
    private List<Sign> results;
    private Map<String, Object> request, session;
    @Autowired
    private ITeacherService teacherService = null;

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setResults(List<Sign> results) {
        this.results = results;
    }

    public List<Sign> getResults() {
        return results;
    }

    public String getSearchMess() {
        return searchMess;
    }

    public void setSearchMess(String searchMess) {
        this.searchMess = searchMess;
    }

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }

    /**
     * 教师登录
     */
    public String login() {
        System.out.println("正在执行TeacherAction的login方法...");
        if (teacherService.login(teacher)) {
            return "success";
        } else
            return "fail";
    }

    /**
     * 传入一个教师的信息，添加教师信息
     */
    public String teacherAdd() {
        try {
            System.out.println("正在执行TeacherAction的teacherAdd方法...");
            if (teacher != null && teacherService.insertTeacher(teacher)) {
                return "teacherAddSuccess";
            } else {
                return "teacherAddFail";
            }
        } catch (Exception e) {
            return "login";
        }
    }

    /**
     * 返回所有的教师信息
     */
    public String getAllTeachers() {
        try {
            System.out.println("正在执行TeacherAction的getAllTeachers方法...");
            if (teacherService.listAllTeacher())
                return "getAllTeachersSuccess";
            else
                return "getAllTeachersFail";

        } catch (Exception e) {
            return "login";
        }
    }

    /**
     * 传入查询信息和查询类型，返回一个教师list
     */
    public String teacherSearch() {
        try {
            System.out.println("正在执行TeacherAction的teacherSearch方法...");
            if (teacherService.searchTeacher(searchMess, searchType))
                return "searchTeacherSuccess";
            else
                return "searchTeacherFail";
        } catch (Exception e) {
            return "login";

        }
    }
}
