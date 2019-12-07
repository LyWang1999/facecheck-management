package cn.edu.zjut.service;

import cn.edu.zjut.po.Sign;
import cn.edu.zjut.po.SignInstanceTemplate;
import cn.edu.zjut.po.TaskList;

public interface ITaskService {

    public boolean insertSign(Sign sign);

    public boolean insertTemplate(SignInstanceTemplate template);

    public TaskList getTaskList(int teaID);

    public boolean deleteTemplate(int templateId);


}
