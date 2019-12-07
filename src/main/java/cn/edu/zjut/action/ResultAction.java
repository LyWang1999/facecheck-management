package cn.edu.zjut.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import cn.edu.zjut.po.*;
import cn.edu.zjut.service.*;

//大打卡有关
@Controller
public class ResultAction extends ActionSupport {
    private Sign result; //大打卡信息
    private List<Sign> results;//大打卡信息列表
    private Teacher teacher;
    private String message;
    private int searchType;
    private Map<String, Object> request, session;

    @Autowired
    //@Resource(name="resultService")
    private IResultService resultService;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }

    public void setResult(Sign result) {
        this.result = result;
    }

    public Sign getResult() {
        return result;
    }

    public void setResults(List<Sign> results) {
        this.results = results;
    }

    public List<Sign> getResults() {
        return results;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public IResultService getResultService() {
        return resultService;
    }

    @Resource

    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    /**
     * 根据教师的ID查看该教师发布的所有签到
     *
     * @return
     * @Author 李璐瑶
     */
    public String lookAllSign()//根据teacher_id查看该老师发布的所有签到信息
    {
        try {
            ActionContext ctx = ActionContext.getContext();
            session = (Map) ctx.getSession();
            teacher = ((Teacher) (session.get("teacher")));
            results = (List<Sign>) resultService.getByTeacher_id(teacher.getTeaID());
            return "success-lookAll";
        } catch (Exception e) {
            return "fail";
        }
    }

    /**
     * 根据签到名查询签到
     *
     * @return
     * @Author 李璐瑶
     */
    public String getByName()//根据签到名称查找       teacher_id和sign_name查看该老师发布的信息
    {
        try {
            results = (List<Sign>) resultService.getBySign_name(result.getName(), teacher.getTeaID());
            return "success-Byname";
        } catch (Exception e) {
            return "fail";
        }
    }

    /**
     * 根据创建时间查询签到
     *
     * @return
     * @Author 李璐瑶
     */
    public String getByTime()//根据签到发布时间       teacher_id和createtime查看该老师发布的所有签到信息
    {
        try {
            results = (List<Sign>) resultService.getByCreatetime(String.valueOf(result.getCreateTime()), teacher.getTeaID());
            return "success-Bytime";
        } catch (Exception e) {
            return "fail";
        }
    }

    /**
     * 用户选择查询类别，输入查询信息，查询签到
     *
     * @return
     * @Author 李璐瑶
     */
    public String findSign() {
        try {
            results = (List<Sign>) resultService.find(message, searchType, teacher.getTeaID());
            return "success-find";
        } catch (Exception e) {
            return "fail";
        }
    }
}
