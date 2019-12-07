package cn.edu.zjut.service;


import cn.edu.zjut.po.Teacher;

public interface ITeacherService {
    /**
     * Jww:验证登录信息
     */
    public boolean login(Teacher teacher);

    /**
     * 插入一条学生信息
     */
    public boolean insertTeacher(Teacher teacher);

    /**
     * 修改一个教师的信息
     */
    public boolean updateTeacher(Teacher teacher);

    /**
     * 通过教师id删除一个教师的信息
     */
    public boolean deleteTeacher(int teaID);

    /**
     * 查找所有的教师信息
     */
    public boolean listAllTeacher();

    /**
     * 通过教师id查找教师
     */
    public Teacher getTeacherByID(int teaID);

    /**
     * 通过不同的方式查找教师
     */
    public boolean searchTeacher(String teaMess, int type);
}
