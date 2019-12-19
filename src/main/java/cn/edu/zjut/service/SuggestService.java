package cn.edu.zjut.service;

import cn.edu.zjut.dao.SuggestMapper;
import cn.edu.zjut.po.Suggest;

import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Scope("prototype")
public class SuggestService implements ISuggestService {
    private Map<String, Object> request;

    @Autowired
    private SuggestMapper suggestMapper = null;

    @Override
    public boolean getStudentSuggest(){
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        try{
            List<Suggest> studentSuggestList = suggestMapper.listStudentSuggest();
            Collections.reverse(studentSuggestList);
            request.put("studentSuggestList",studentSuggestList);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean getTeacherSuggest(){
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        try{
            List<Suggest> teacherSuggestList = suggestMapper.listTeacherSuggest();
            Collections.reverse(teacherSuggestList);
            request.put("teacherSuggestList",teacherSuggestList);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insertTeacherSuggest(String teacherID,String suggest){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = df.format(new Date());// new Date()为获取当前系统时间
        try{
            System.out.println(teacherID);
            suggestMapper.insertTeacherSuggest(Integer.parseInt(teacherID),suggest,time);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
