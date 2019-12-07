package cn.edu.zjut.dao;

import cn.edu.zjut.po.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentMapper {
    /**
     * 新增学生
     */
    public void insertStudent(Student student) throws Exception;

    /**
     * 修改学生
     */
    public int updateStudent(Student student) throws Exception;

    /**
     * 刪除学生
     */
    public void deleteStudent(int id) throws Exception;

    /**
     * 根据id查询学生信息
     */
    public Student getStudentById(int id) throws Exception;

    /**
     * 根据name查询学生信息
     */
    public List<Student> getStudentByName(String name) throws Exception;

    /**
     * 查询所有的学生信息
     */
    public List<Student> listAllStudent() throws Exception;

    /**
     * 查询一个班级的学生信息
     */
    public List<Student> listStudentByClass(String className) throws Exception;

    /**
     * 查询一个专业的学生信息
     */
    public List<Student> listStudentByDepart(String departName) throws Exception;

    /**
     *
     * @param stuField
     * @throws Exception
     */
    public void insertStudentExcel(ArrayList<Student> stuField) throws Exception;

    /**
     * @param stuField
     * @throws Exception
     */
    public void insertStudentFace(ArrayList<Student> stuField) throws Exception;

    /**
     * @param student
     * @throws Exception
     */
    public void insertOneStudentFace(Student student) throws Exception;

    /**
     * 加入Score数据库科
     */
    public void insertStudentScore(ArrayList<Student> stuField)throws  Exception;

    /**
     * 在积分表中插入一个学生的基础信息
     */
    public void insertOneStudentScore(Student student)throws  Exception;

    public String getOpenid(int stuID);
}
