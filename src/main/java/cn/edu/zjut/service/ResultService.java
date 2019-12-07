package cn.edu.zjut.service;


import cn.edu.zjut.dao.ResultMapper;
import cn.edu.zjut.po.Sign;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ResultService implements IResultService {
    @Autowired
    private Map<String, Object> request, session;
    private ResultMapper resultmapper;

    public ResultService() {

    }

    @Resource
    public void setResultmapper(ResultMapper resultmapper) {
        this.resultmapper = resultmapper;
    }

    /**
     * 根据教师的ID获得该教师发布的签到
     *
     * @param teacher_id
     * @return
     * @Author 李璐瑶
     */
    @Override
    public List<Sign> getByTeacher_id(int teacher_id) {
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        session = (Map) ctx.getSession();
        List<Sign> list = new ArrayList();
        try {
            list = resultmapper.selectByTeacher_id(teacher_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.put("list", list);
        return list;
    }

    /**
     * 根据签到名称查找签到
     *
     * @param sign_name
     * @param teacher_id
     * @return
     * @Author 李璐瑶
     */
    @Override
    public List<Sign> getBySign_name(String sign_name, int teacher_id) {
        List<Sign> list = new ArrayList();
        try {
            list = resultmapper.selectBySign_name(sign_name, teacher_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据创建时间查询签到
     *
     * @param createtime
     * @param teacher_id
     * @return
     * @Author 李璐瑶
     */
    @Override
    public List<Sign> getByCreatetime(String createtime, int teacher_id) {
        List<Sign> list = new ArrayList();
        try {
            list = resultmapper.selectByCreatetime(createtime, teacher_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据查找类别，和输入的查询信息查询签到信息
     *
     * @param message
     * @param type
     * @param teaID
     * @return
     * @Author 李璐瑶
     */
    public List<Sign> find(String message, int type, int teaID) {
        ActionContext ctx = ActionContext.getContext();
        session = ctx.getSession();
        List<Sign> list = new ArrayList();
        try {
            if (type == 1) {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                return this.getByCreatetime(message, teaID);
            } else {
                return this.getBySign_name(message, teaID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据签到ID查询签到
     *
     * @param sign_id
     * @return
     * @Author 李璐瑶
     */
    @Override
    public Sign getBySign_id(String sign_id) {
        Sign sign = null;
        try {
            sign = resultmapper.selectBySign_id(sign_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sign;
        // TODO Auto-generated method stub
    }
}
