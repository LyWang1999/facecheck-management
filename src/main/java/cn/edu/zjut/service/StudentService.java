package cn.edu.zjut.service;

import cn.edu.zjut.dao.StudentMapper;
import cn.edu.zjut.po.Student;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentService implements IStudentService {
    private Map<String, Object> request, session;

    @Autowired
    StudentMapper studentMapper = null;

    /**
     * 插入学生
     */
    @Override
    @Transactional
    public void insertStudent(Student student) {
        System.out.println("正在执行StudentService的insertStudent方法...");
        try {
            studentMapper.insertStudent(student);
            studentMapper.insertOneStudentFace(student);
            studentMapper.insertOneStudentScore(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新学生信息
     */
    @Override
    @Transactional
    public boolean updateStudent(Student student) {
        System.out.println("正在执行StudentService的updateStudent方法...");
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        try {
            if (student != null && studentMapper.updateStudent(student) != 0) {
                System.out.println("学生信息更新成功");
                request.put("student", student);
                request.put("tip", "学生信息更新成功！");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.put("tip", "学生信息更新失败！");
            return false;
        }
        request.put("tip", "学生信息更新失败！");
        return false;
    }

    /**
     * 删除学生信息
     */
    @Override
    @Transactional
    public boolean deleteStudent(int stuID) {
        System.out.println("正在执行StudentService的deleteStudent方法...");
        ActionContext ctx = ActionContext.getContext();
        session = ctx.getSession();
        try {
            studentMapper.deleteStudent(stuID);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        List<Student> studentList = (List<Student>) session.get("studentList");
        for (Student student : studentList) {
            if (student.getStuID() == stuID) {
                studentList.remove(student);
                break;
            }
        }
        session.put("studentList", studentList);
        return true;
    }

    /**
     * 传入学生ID，返回学生的信息
     */
    @Override
    @Transactional
    public Student searchStudentByID(int stuID) {
        System.out.println("正在执行StudentService的searchStudentByID方法...");
        try {
            return studentMapper.getStudentById(stuID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 传入学生班级，返回学生的信息
     */
    @Override
    @Transactional
    public List<Student> searchStudentByClass(String className) {
        System.out.println("正在执行StudentService的searchStudentByClass方法...");
        try {
            return studentMapper.listStudentByClass(className);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 传入学生学院，返回学生的信息
     */
    @Override
    @Transactional
    public List<Student> searchStudentByDepart(String departName) {
        System.out.println("正在执行StudentService的searchStudentByDepart方法...");
        try {
            return studentMapper.listStudentByDepart(departName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 传入查询条件，返回学生的信息
     */
    @Override
    @Transactional
    public boolean searchStudent(String stuMess, int type) {
        System.out.println("正在执行StudentService的searchStudent方法...");
        ActionContext ctx = ActionContext.getContext();
        session = ctx.getSession();
        List<Student> studentList = new ArrayList<Student>();
        // 0:按学号查询；1：按姓名查询；2：按班级查询；3：按专业查询
        try {
            switch (type) {
                case 0:
                    Student student = studentMapper.getStudentById(Integer.parseInt(stuMess));
                    if(student!=null)
                        studentList.add(student);
                    break;
                case 1:
                    studentList = studentMapper.getStudentByName(stuMess);
                    break;
                case 2:
                    studentList = studentMapper.listStudentByClass(stuMess);
                    break;
                case 3:
                    studentList = studentMapper.listStudentByDepart(stuMess);
                    break;
            }
        } catch (Exception e) {
            return false;
        }
        if (studentList != null) {
            session.put("studentList", studentList);
        }
        else {
            session.put("studentList", null);
        }
        return true;
    }

    /**
     * 返回所有学生的信息
     */
    @Override
    @Transactional
    public boolean listAllStudent() {
        System.out.println("正在执行StudentService的listAllStudent方法...");
        ActionContext ctx = ActionContext.getContext();
        session = ctx.getSession();
        List<Student> studentList = null;
        try {
            studentList = studentMapper.listAllStudent();
            session.put("studentList", studentList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean showStudent(int stuID) {
        System.out.println("正在执行StudentService的showStudent方法...");
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        try {
            Student student = studentMapper.getStudentById(stuID);
            request.put("student", student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
