package cn.edu.zjut.action;

import cn.edu.zjut.po.Student;
import cn.edu.zjut.service.IStudentService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Scope("prototype")
@Controller
public class StudentAction {
    private Map<String, String> request;
    private Student student;
    private String searchMess;
    private int searchType;

    @Autowired
    private IStudentService studentService;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
     * 传入学生信息，添加一条学生信息
     */
    public String studentAdd() {
        System.out.println("正在执行StudentAction的studentAdd方法...");
        ActionContext ctx = ActionContext.getContext();
        request = (Map<String, String>) ctx.get("request");
        try {
            if (student != null) {
                studentService.insertStudent(student);
                System.out.println("添加学生成功");
                request.put("tip", student.getName() + "信息添加成功！");
                return "studentAddSuccess";
            } else {
                request.put("tip", "添加失败！");
                return "studentAddFail";
            }
        } catch (Exception e) {
            return "login";
        }
    }

    /**
     * 传入搜索信息和搜索类型，返回搜索结果的list
     */
    public String stuSearch() {
        System.out.println("正在执行StudentAction的studentAdd方法...");
        try {
            boolean search = studentService.searchStudent(searchMess, searchType);
            if (search)
                return "stuSearchSuccess";
            else
                return "stuSearchFail";
        } catch (Exception e) {
            return "login";
        }
    }

    /**
     * 返回所有的学生信息
     */
    public String allStudents() {
        System.out.println("正在执行StudentAction的allStudents方法...");
        try {
            if (studentService.listAllStudent()) {
                return "allStudentsSuccess";
            } else {
                return "allStudentsFail";
            }
        } catch (Exception e) {
            return "login";
        }
    }
}
