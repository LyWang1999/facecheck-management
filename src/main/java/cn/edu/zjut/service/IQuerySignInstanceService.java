package cn.edu.zjut.service;

import cn.edu.zjut.po.SignInstance;

import java.util.List;

/**
 * author:黄丹
 *用于与dao层的QuerySigninstanceMapper进行数据交互的service层接口
 *被QuerySignInstanceService实现
 */
public interface IQuerySignInstanceService {
    List<SignInstance> getSignInstance(int signID) throws Exception;//查询某一打卡id下的详细打卡信息
}
