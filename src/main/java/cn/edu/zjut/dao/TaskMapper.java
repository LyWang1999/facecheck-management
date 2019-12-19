package cn.edu.zjut.dao;

import cn.edu.zjut.po.Sign;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMapper {

    void insertSignProject(Sign sign) throws Exception;

    List<Sign> getSignProjectById(int teaID) throws Exception;
}
