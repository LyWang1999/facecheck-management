package cn.edu.zjut.service;

import cn.edu.zjut.po.Suggest;

public interface ISuggestService {
    /**
     * @Author 卢益铭
     * @Describe 传入教师ID和建议信息，操作dao将教师建议写入数据库
     * @param teacherID
     * @param suggest
     * @return
     */
    public boolean insertTeacherSuggest(String teacherID, String suggest);

    /**
     * @Author 卢益铭
     * @Describe 通过dao查询到教师所有的反馈，按时间倒序排序
     * @return
     */
    public boolean getTeacherSuggest();

    /**
     * @Author 卢益铭
     * @Describe 通过dao查询到学生所有的反馈，按时间倒序排序
     * @return
     */
    public boolean getStudentSuggest();
}
