package cn.edu.zjut.service;

import cn.edu.zjut.dao.DailyResultMapper;
import cn.edu.zjut.po.DailyResult;
import cn.edu.zjut.po.SignInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DailyResultService implements IDailyResultService {
    @Autowired
    private DailyResultMapper dailyresultmapper;

    public DailyResultService() {

    }

    public void setDailyresultmapper(DailyResultMapper dailyresultmapper) {
        this.dailyresultmapper = dailyresultmapper;
    }

    /**
     * 根据大打卡的id得到小打卡列表
     *
     * @param signID
     * @return
     * @author 王凌云
     */

    @Override
    public List<SignInstance> getBySign_id(String signID) {
        List<SignInstance> list = new ArrayList();
        try {
            list = (List<SignInstance>) dailyresultmapper.selectBySign_id(signID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
        // TODO Auto-generated method stub
    }

    /**
     * 根据小打卡id查找某个具体的小打卡
     *
     * @param signInstID
     * @return
     * @author 王凌云
     */
    @Override
    public DailyResult getBySigninstance_id(int signInstID) {
        DailyResult dailyresult = new DailyResult();
        SignInstance signinstance = null;
        try {
            signinstance = dailyresultmapper.selectBySigninstance_id(signInstID);
            int allpeople = dailyresultmapper.selectNumberofAll(signInstID);
            int fact = dailyresultmapper.selectNumberofFact(signInstID);
            dailyresult.setAll(allpeople);
            dailyresult.setFact(fact);
            dailyresult.setSign_name(dailyresultmapper.selectSign_name(signInstID));
            dailyresult.setSigninstance(signinstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dailyresult;
    }

}
