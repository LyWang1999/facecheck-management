package cn.edu.zjut.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.edu.zjut.po.*;
import cn.edu.zjut.service.*;

@Controller
public class DailyResultAction {
    private SignInstance signinstance; //签到实例
    private Sign result; //签到信息
    private List<SignInstance> signinstances;//签到实例列表
    @Autowired
    private IDailyResultService dailyresultService;
    @Autowired
    private IResultService resultService;

    public IResultService getResultService() {
        return resultService;
    }

    @Resource
    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    public void setResult(Sign result) {
        this.result = result;
    }

    public Sign getResult() {
        return result;
    }

    public void setSigninstance(SignInstance signinstance) {
        this.signinstance = signinstance;
    }

    public SignInstance getSigninstance() {
        return signinstance;
    }

    public void setSigninstances(List<SignInstance> signinstances) {
        this.signinstances = signinstances;
    }

    public List<SignInstance> getSigninstances() {
        return signinstances;
    }

    public IDailyResultService getDailyresultService() {
        return dailyresultService;
    }

    @Resource

    public void setDailyresultService(IDailyResultService dailyresultService) {

        this.dailyresultService = dailyresultService;
    }

    /**
     * 根据签到的ID获得该签到的列表
     *
     * @return
     * @author 王凌云
     */
    public String getDailyResult() {//根据大打卡的sign_id得到小打卡的列表
        //signinsatnce的sign_id由jsp传过来
        signinstances = (List<SignInstance>) dailyresultService.getBySign_id(String.valueOf(signinstance.getSignID()));
        //得到大打卡的名称
        result = resultService.getBySign_id(String.valueOf(signinstance.getSignID()));
        return "success-Daily";
    }

}
