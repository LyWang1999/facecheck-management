package cn.edu.zjut.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.zjut.po.*;

@Repository
public interface DailyResultMapper {

    List<SignInstance> selectBySign_id(String signID);

    SignInstance selectBySigninstance_id(int signInstID);

    int selectNumberofAll(int signInstID);

    int selectNumberofFact(int signInstID);

    String selectSign_name(int signInstID);

}
