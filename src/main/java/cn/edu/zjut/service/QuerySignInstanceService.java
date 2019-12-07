package cn.edu.zjut.service;

import cn.edu.zjut.dao.QuerySignInstanceMapper;
import cn.edu.zjut.po.SignInstance;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuerySignInstanceService implements IQuerySignInstanceService {
    @Resource
    QuerySignInstanceMapper querySignInstanceMapper;


    @Override
    public List<SignInstance> getSignInstance(int signID) throws Exception {
        return querySignInstanceMapper.getSignInstance(signID);
    }
}
