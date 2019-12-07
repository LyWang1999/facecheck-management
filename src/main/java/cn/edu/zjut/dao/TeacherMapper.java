package cn.edu.zjut.dao;

import cn.edu.zjut.po.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {
    public Teacher findById(int id);

    /**
     * 通过id查找教师
     */
    public Teacher getTeacherById(int id) throws Exception;

    /**
     * 返回所有教师的列表
     */
    public List<Teacher> listAllTeacher() throws Exception;

    /**
     * 添加一条教师记录
     */
    public int insertTeacher(Teacher teacher) throws Exception;

    /**
     * 根据教师id删除一条教师信息
     */
    public void deleteTeacher(int id) throws Exception;

    /**
     * 更新教师信息
     */
    public int updateTeacher(Teacher teacher) throws Exception;

    /**
     * 通过姓名查找教师
     */
    public List<Teacher> listTeacherByName(String name) throws Exception;

}
