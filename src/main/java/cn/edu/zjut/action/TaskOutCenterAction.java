package cn.edu.zjut.action;

import cn.edu.zjut.po.*;
import cn.edu.zjut.service.ISignInstanceService;
import cn.edu.zjut.service.IStudentService;
import cn.edu.zjut.service.ITaskService;
import cn.edu.zjut.service.SignInstanceService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
public class TaskOutCenterAction {

    @Autowired
    private ITaskService taskService;

    @Autowired
    private ISignInstanceService signInstanceService;

    @Autowired
    private IStudentService studentService;
    private String datelist;
    private String stulist;
    private Map<String, Object> actionRequest;
    private Sign sign;
    private SignInstanceTemplate template;
    private int templateid;


    public Sign getSign() {
        return sign;
    }

    public String getDatelist() {
        return datelist;
    }

    public void setDatelist(String datelist) {
        this.datelist = datelist;
    }

    public String getStulist() {
        return stulist;
    }

    public void setStulist(String stulist) {
        this.stulist = stulist;
    }


    public Map<String, Object> getActionRequest() {
        return actionRequest;
    }

    public void setActionRequest(Map<String, Object> actionRequest) {
        this.actionRequest = actionRequest;
    }


    public void setSign(Sign sign) {
        this.sign = sign;
    }


    public SignInstanceTemplate getTemplate() {
        return template;
    }

    public void setTemplate(SignInstanceTemplate template) {
        this.template = template;
    }


    public int getTemplateid() {
        return templateid;
    }

    public void setTemplateid(int templateid) {
        this.templateid = templateid;
    }

    /**
     * 教师生成签到的实例
     */
    public String buildTask() {
        try {
            if (sign != null) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                sign.setCreateTime((new Date()));
                taskService.insertSign(sign);//插入计划
            }
            return "success";

        } catch (Exception e) {
            return "fail";
        }
    }

    /**
     * 教师创建合适的模板
     */
    public String buildTemplate()
    {

        Date date = null;
        DateFormat format = new SimpleDateFormat("HH:mm");
        HttpServletRequest request = ServletActionContext.getRequest();
        String beginTime = request.getParameter("template.startTime");//字符串
        beginTime = beginTime + ":00";
        System.out.println(beginTime);
        String endTime = request.getParameter("template.endTime");//字符串
        endTime = endTime + ":00";
    /*
     * 转换日期格式
     */
        try {
            date = format.parse(beginTime);

            template.setStartTime(new Time(date.getTime()));
            date = format.parse(endTime);
            template.setEndTime(new Time(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            return "fail";
        }
        taskService.insertTemplate(template);//插入到模板类


        return "success";
    }

    /**
     * 登入教师界面时 把信息录入到session并存储计划表的List
     */
    public String inToPlatform() {
        try {
            Map session = ActionContext.getContext().getSession();
            Teacher teacher = (Teacher) session.get("teacher");
            TaskList taskList = taskService.getTaskList(teacher.getTeaID());

            session.put("taskList", taskList);//存储计划信息
            session.put("teaID", teacher.getTeaID());//存储教师id
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    /**
     * 根据模板名称 计划名称 进入到打卡实例的创建目录
     */
    public String gotoinstance() {
        try {
            actionRequest = (Map) ActionContext.getContext().get("request");
            List<Student> students = signInstanceService.listAllStudents();
            System.out.println(students.get(0).getName());
            HttpServletRequest request = ServletActionContext.getRequest();
            String templateid = request.getParameter("templateid");
            String chooseid = request.getParameter("chooseid");
            String choosename = request.getParameter("choosename");
            System.out.println(templateid);
            /*
             * 存储相应的计划id 模板id 选择的计划名称
             */
            request.setAttribute("templateid", templateid);
            request.setAttribute("chooseid", chooseid);
            request.setAttribute("choosename", choosename);
            System.out.println(chooseid);
            System.out.println(choosename);
            System.out.println(templateid);
            actionRequest.put("students", students);

            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    /**
     * 根据所选的学生和打卡日期生成打卡实例
     */
    public String newIns() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            System.out.println("学号是" + stulist);
            int chooseid = Integer.parseInt(request.getParameter("chooseid"));
            /*
             * 解析发送来的日期信息和学生内容
             */
            String[] date_list = datelist.split(",");
            String[] stu_list = stulist.split(",");
            signInstanceService.insertSignInstance(stu_list, date_list, templateid, chooseid);
            return "success";

        } catch (Exception e) {
            return "fail";
        }
    }

    /**
     * 删除打卡模板
     */
    public String deleteInstance() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            String templateid = request.getParameter("templateid");
            int templateId = Integer.parseInt(templateid);//获得模板id
            taskService.deleteTemplate(templateId);//删除模板id
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

}
