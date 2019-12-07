package cn.edu.zjut.service;

import cn.edu.zjut.dao.TaskMapper;
import cn.edu.zjut.dao.TemplateMapper;
import cn.edu.zjut.po.Sign;
import cn.edu.zjut.po.SignInstanceTemplate;
import cn.edu.zjut.po.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements ITaskService {
    @Autowired
    TaskMapper taskMapper = null;
    @Autowired
    TemplateMapper templateMapper = null;

    /*
     *  教师功能中打卡计划的插入
     */
    public boolean insertSign(Sign sign) {

        try {
            taskMapper.insertSignProject(sign);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    /*
     * 教师功能中模板信息的插入
     */
    public boolean insertTemplate(SignInstanceTemplate template) {

        try {
            templateMapper.insertTemplate(template);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    /*
     * 教师模板管理中的模板删除功能
     */
    public boolean deleteTemplate(int templateId) {

        try {
            templateMapper.DeleteTemplate(templateId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * 查询相应教师存储的所有签到计划
     */
    public TaskList getTaskList(int teaID) {

        TaskList taskList = new TaskList();

        try {

            taskList.setTeaID(teaID);
            taskList.setSigns(taskMapper.getSignProjectById(teaID));
            System.out.println(taskMapper.getSignProjectById(teaID));
            taskList.setTemplates(templateMapper.getTemplateByTid(teaID));


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return taskList;
    }


}
