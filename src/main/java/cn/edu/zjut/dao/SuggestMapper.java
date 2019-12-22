package cn.edu.zjut.dao;

import cn.edu.zjut.po.Suggest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuggestMapper {

    /**
     * @author 吴一帆
     * @Describe 返回所有的学生反馈
     * @return
     */
    List<Suggest> listStudentSuggest();

    /**
     * @author 吴一帆
     * @Describe 返回所有的教师反馈
     * @return
     */
    List<Suggest> listTeacherSuggest();

    /**
     * @author 吴一帆
     * @Describe 教师插入一条反馈
     * @param teacherID
     * @param suggest
     * @param time
     * @return
     */
    int insertTeacherSuggest(@Param("teacherID") int teacherID, @Param("suggest")String suggest, @Param("time")String time);
}
