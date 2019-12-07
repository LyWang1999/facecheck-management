package cn.edu.zjut.service;


import cn.edu.zjut.dao.TeacherMapper;
import cn.edu.zjut.po.Teacher;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Scope("prototype")
public class TeacherService implements ITeacherService {
    private Map<String, Object> request, session;

    @Autowired
    private TeacherMapper teacherMapper = null;

    @Override
    @Transactional
    public boolean login(Teacher teacher) {
        System.out.println("正在执行TeacherService的login方法...");
        ActionContext ctx = ActionContext.getContext();
        session = ctx.getSession();
        Teacher instance = new Teacher();
        try {
            instance = teacherMapper.findById(teacher.getTeaID());
            if (instance == null) {
                System.out.println("未找到老师");
                return false;
            }
            if (instance.getPassword().equals(teacher.getPassword())) {
                System.out.println("登录成功");
                teacher = instance;
                session.put("teacher", teacher);
                return true;
            }
            else{
                System.out.println("密码错误");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean insertTeacher(Teacher teacher) {
        System.out.println("正在执行TeacherService的insertTeacher方法...");
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        try {
            if (teacher != null)
                teacher.setPassword("123456");//插入默认密码
            if (teacherMapper.insertTeacher(teacher) != 0) {
                System.out.println("教师信息插入成功");
                request.put("tip", teacher.getName() + "教师信息插入成功！");
                return true;
            }
        } catch (Exception e) {
            request.put("tip", "教师信息插入失败！");
            return false;
        }
        request.put("tip", "教师信息插入失败！");
        return false;
    }

    @Override
    @Transactional
    public boolean updateTeacher(Teacher teacher) {
        System.out.println("正在执行TeacherService的updateTeacher方法...");
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        try {
            if (teacher != null && teacherMapper.updateTeacher(teacher) != 0) {
                System.out.println("教师信息更新成功");
                request.put("teacher",teacher);
                request.put("tip", "教师信息更新成功！");
                return true;
            }
        } catch (Exception e) {
            request.put("tip", "教师信息更新失败！");
            return false;
        }
        request.put("tip", "教师信息更新失败！");
        return false;
    }

    @Override
    @Transactional
    public boolean deleteTeacher(int teaID) {
        System.out.println("正在执行TeacherService的deleteTeacher方法...");
        ActionContext ctx = ActionContext.getContext();
        session = ctx.getSession();
        try {
            teacherMapper.deleteTeacher(teaID);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        List<Teacher> teacherList = (List<Teacher>) session.get("teacherList");
        for (Teacher teacher : teacherList) {
            if (teacher.getTeaID() == teaID) {
                teacherList.remove(teacher);
                break;
            }
        }
        session.put("teacherList", teacherList);
        return true;
    }

    @Override
    @Transactional
    public boolean listAllTeacher() {
        System.out.println("正在执行TeacherService的listAllTeacher方法...");
        ActionContext ctx = ActionContext.getContext();
        session = ctx.getSession();
        List<Teacher> teacherList = null;
        try {
            teacherList = teacherMapper.listAllTeacher();
            session.put("teacherList", teacherList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public Teacher getTeacherByID(int teaID) {
        System.out.println("正在执行TeacherService的getTeacherByID方法...");
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        try {
            Teacher teacher = teacherMapper.getTeacherById(teaID);
            return teacher;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean searchTeacher(String teaMess, int type) {
        System.out.println("正在执行TeacherService的searchTeacher方法...");
        ActionContext ctx = ActionContext.getContext();
        session = ctx.getSession();
        List<Teacher> teacherList = new ArrayList<Teacher>();;
        // 0:按学号查询；1：按姓名查询；
        try {
            switch (type) {
                case 0:
                    Teacher teacher = teacherMapper.getTeacherById(Integer.parseInt(teaMess));
                    if(teacher!=null)
                        teacherList.add(teacher);
                    break;
                case 1:
                    teacherList = teacherMapper.listTeacherByName(teaMess);
                    break;
            }
        } catch (Exception e) {
            return false;
        }
        if (teacherList != null)
            session.put("teacherList", teacherList);
        else
            session.put("teacherList",null);
        return true;
    }
}
