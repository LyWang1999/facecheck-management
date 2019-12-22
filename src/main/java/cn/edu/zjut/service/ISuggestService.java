package cn.edu.zjut.service;

import cn.edu.zjut.po.Suggest;

public interface ISuggestService {
    /**
     * @author 吴一帆
     * @Describe 传入教师ID和建议信息，操作dao将教师建议写入数据库
     * @param teacherID
     * @param suggest
     * @return
     */
    boolean insertTeacherSuggest(String teacherID, String suggest);

    /**
     * @author 吴一帆
     * @Describe 通过dao查询到教师所有的反馈，按时间倒序排序
     * @return
     */
    boolean getTeacherSuggest();

    /**
     * @author 吴一帆
     * @Describe 通过dao查询到学生所有的反馈，按时间倒序排序
     * @return
     */
    boolean getStudentSuggest();
}
