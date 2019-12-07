package cn.edu.zjut.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.edu.zjut.po.*;
import cn.edu.zjut.service.*;

//某个打卡下学生签到情况
@Controller
public class ResultDetailAction {
    private DailyResult dailyresult; //小打卡
    private Sign result; //大打卡
    private ResultDetail resultdetail;//打卡情况
    private List<ResultDetail> resultdetails = null;
    @Autowired
    private IDailyResultService dailyresultService;
    @Autowired
    private IResultService resultService;
    @Autowired
    private IResultDetailService resultdetailService;

    public IResultService getResultService() {
        return resultService;
    }

    @Resource
    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    public IDailyResultService getDailyresultService() {
        return dailyresultService;
    }

    @Resource
    public void setDailyresultService(IDailyResultService dailyresultService) {
        this.dailyresultService = dailyresultService;
    }

    public IResultDetailService getResultdetailService() {
        return resultdetailService;
    }

    @Resource
    public void setResultdetailService(IResultDetailService resultdetailService) {
        this.resultdetailService = resultdetailService;
    }

    public void setResultdetail(ResultDetail resultdetail) {
        this.resultdetail = resultdetail;
    }

    public ResultDetail getResultdetail() {
        return resultdetail;
    }

    public void setResultdetails(List<ResultDetail> resultdetails) {
        this.resultdetails = resultdetails;
    }

    public List<ResultDetail> getResultdetails() {
        return this.resultdetails;
    }

    public void setResult(Sign result) {
        this.result = result;
    }

    public Sign getResult() {
        return result;
    }

    public void setDailyresult(DailyResult dailyresult) {
        this.dailyresult = dailyresult;
    }

    public DailyResult getDailyresult() {
        return dailyresult;
    }

    /**
     * 根据某次详细签到的ID获得该次签到的学生签到情况
     *
     * @return
     * @Author 李璐瑶
     */
    public String getResultDetail() {
        try {
            resultdetails = resultdetailService.getBySignInstance_id(dailyresult.getSigninstance().getSignInstID());//获取签到结果情况
            dailyresult = dailyresultService.getBySigninstance_id(dailyresult.getSigninstance().getSignInstID());
            return "success-getDetail";
        } catch (Exception e) {
            return "fail";
        }
    }

    /**
     * 修改学生的签到情况
     *
     * @return
     * @Author 李璐瑶
     */
    public String changeResult() {//修改学生签到情况
        try {
            resultdetailService.update(resultdetail.getStudentsign().getStuSignID(), resultdetail.getStudentsign().getStatus());
            resultdetails = resultdetailService.getBySignInstance_id(resultdetail.getStudentsign().getSignInstID());
            dailyresult = dailyresultService.getBySigninstance_id(resultdetail.getStudentsign().getSignInstID());
            return "success-Details";
        } catch (Exception e) {
            return "fail";
        }
    }


}
