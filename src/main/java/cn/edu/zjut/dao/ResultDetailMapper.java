package cn.edu.zjut.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.zjut.po.ResultDetail;

@Repository
public interface ResultDetailMapper {
    List<ResultDetail> selectBySigninstance_id(int signInstID);

    void update(Integer stuSignID, Integer status);
}
