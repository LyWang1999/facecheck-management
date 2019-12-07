package cn.edu.zjut.dao;

import cn.edu.zjut.po.Sign;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ResultMapper {
    List<Sign> selectByTeacher_id(int teacher_id) throws Exception;

    Sign selectBySign_id(String sign_id) throws Exception;

    List<Sign> selectBySign_name(String sign_name, int teacher_id) throws Exception;

    List<Sign> selectByCreatetime(String createtime, int teacher_id) throws Exception;


}