package cn.edu.zjut.service;

import cn.edu.zjut.po.ResultDetail;

import java.util.List;

public interface IResultDetailService {
    List<ResultDetail> getBySignInstance_id(int signInstID);

    void update(Integer StuSignID, Integer status);

}
