package cn.edu.zjut.service;

import java.util.Date;
import java.util.List;

import cn.edu.zjut.po.*;

public interface IResultService {
    List<Sign> find(String message, int type, int teaID);

    List<Sign> getByTeacher_id(int tacher_id);

    List<Sign> getBySign_name(String sign_name, int teacher_id);

    List<Sign> getByCreatetime(String createtime, int teacher_id);

    Sign getBySign_id(String sign_id);


}
