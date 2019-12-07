package cn.edu.zjut.service;

import cn.edu.zjut.dao.QuerySignMapper;
import cn.edu.zjut.po.Sign;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuerySignService implements IQuerySignService {
    @Resource
    QuerySignMapper querySignMapper;

    @Override
    public List<Sign> getAllSign() throws Exception {
        return querySignMapper.getAllSign();
    }

    @Override
    public List<Sign> getAllSignByName(String name) throws Exception {
        return querySignMapper.getAllSignByName(name);
    }

    @Override
    public List<Sign> getAllSignByCreatetime(String createtime) throws Exception {
        return querySignMapper.getAllSignByCreatetime(createtime);
    }

    @Override
    public List<Sign> getAllSignByTeaid(int teaID) throws Exception {
        return querySignMapper.getAllSignByTeaid(teaID);
    }

    @Override
    public List<Sign> getAllSignByID(int signID) throws Exception {
        return querySignMapper.getAllSignByID(signID);
    }

    @Override
    public List<Sign> getAllSignValid(String endtime) throws Exception {
        return querySignMapper.getAllSignValid(endtime);
    }

    @Override
    public List<Sign> getAllSignfuzzilybyName(String name) throws Exception {
        return querySignMapper.getAllSignfuzzilybyName(name);
    }

    @Override
    public List<Sign> getAllSignfuzzilybyCal(String cal) throws Exception {
        return querySignMapper.getAllSignfuzzilybyCal(cal);
    }


}
