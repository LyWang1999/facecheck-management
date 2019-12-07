package cn.edu.zjut.dao;

import cn.edu.zjut.po.SignInstance;

import java.util.List;

public interface InstanceMapper {
    public int insertSignInstance(List<SignInstance> instances) throws Exception;
}
