package cn.edu.zjut.action;

import cn.edu.zjut.po.SignInstance;
import cn.edu.zjut.service.IQuerySignInstanceService;
import cn.edu.zjut.service.QuerySignInstanceService;

import java.util.List;

/**
 * author：黄丹
 * 用于查询显示signinsteance表信息的action层
 */
public class QuerySignInstanceaction {
    IQuerySignInstanceService querySignInstanceService;
    List<SignInstance> signInstances;//将信息传到页面去
    int signID;//接收页面传来的打卡id

    /*
    get与set方法用于与jsp页面数据交互
     */
    public List<SignInstance> getSignInstances() {
        return signInstances;
    }

    public void setSignInstances(List<SignInstance> signInstances) {
        this.signInstances = signInstances;
    }

    public int getSignID() {
        return signID;
    }

    public void setSignID(int signID) {
        this.signID = signID;
    }

    /*
    用于得到某个打卡详情的页面action响应
     */
    public String getSignInstance() {
        try {
            querySignInstanceService = CtxUtil.getBean(QuerySignInstanceService.class);
            System.out.println(signID);
            signInstances = querySignInstanceService.getSignInstance(signID);
            for (SignInstance signInstance : signInstances)
                System.out.println(signInstance.getEndTime());
            return "getSignInstancesuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "getSignInstancefail";
        }
    }

}
