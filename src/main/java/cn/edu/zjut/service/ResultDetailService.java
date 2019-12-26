package cn.edu.zjut.service;

import cn.edu.zjut.dao.ResultDetailMapper;
import cn.edu.zjut.po.ResultDetail;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ResultDetailService implements IResultDetailService {
    private Map<String, Object> request, session;
    @Autowired
    private ResultDetailMapper resultdetailmapper;

    public ResultDetailService() {
    }

    @Resource
    public void setResultdetailmapper(ResultDetailMapper resultdetailmapper) {
        this.resultdetailmapper = resultdetailmapper;
    }

    /**
     * 根据某个详细签到的ID获得学生的签到情况
     *
     * @param signInstID
     * @return
     * @author 王凌云
     */
    @Override
    public List<ResultDetail> getBySignInstance_id(int signInstID) {//根据小打卡id获得该打卡的学生打卡情况
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        session = (Map) ctx.get("session");

        List<ResultDetail> list = new ArrayList();
        try {
            list = (List<ResultDetail>) resultdetailmapper.selectBySigninstance_id(signInstID);
            for (ResultDetail resultDetail: list){
                String url = resultDetail.getStudentsign().getStuImgUrl();
                String[] array = new String[7];
                if(url.indexOf("//") == -1){
                    continue;
                }
                array = url.split("//");
                System.out.println(url);
                String newUrl = "http://101.132.166.211:8080/checkin/register/"+array[6];
                resultDetail.getStudentsign().setStuImgUrl(newUrl);
                System.out.println(resultDetail.getStudentsign().getStuImgUrl());
            }
            request.put("list", list);
            session.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 修改指定学生指定签到下的签到情况
     *
     * @param StuSignID
     * @param status
     * @author 王凌云
     */
    @Override
    public void update(Integer StuSignID, Integer status) {//修改学生打卡情况
        try {
            resultdetailmapper.update(StuSignID, status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO Auto-generated method stub

    }

}
