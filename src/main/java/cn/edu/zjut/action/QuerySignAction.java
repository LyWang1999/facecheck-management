package cn.edu.zjut.action;

import cn.edu.zjut.po.Sign;
import cn.edu.zjut.service.IQuerySignService;
import cn.edu.zjut.service.QuerySignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class QuerySignAction {
    List<Sign> signs;
    String query;
    String input;
    String val;
    @Autowired
    IQuerySignService querySignService;

    /*
     *set和get方法用于和jsp页面交互数据
     */
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Sign> getSigns() {
        return signs;
    }

    public void setSigns(List<Sign> signs) {
        this.signs = signs;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    /*
     *得到所有的打卡信息
     */
    public String getAllSign() {
        try {
            signs = querySignService.getAllSign();
            return "getAllSignSuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "getAllSignFail";
        }
    }

    /*
     * 根据id查询sign表的信息
     */
    public String getAllSignByID() {
        try {
            querySignService = CtxUtil.getBean(QuerySignService.class);
            signs = querySignService.getAllSignByID(Integer.parseInt(input));
            return "querySignSuccess";

        } catch (Exception e) {
            e.printStackTrace();
            return "querySignFail";
        }
    }

    /*
     * 根据名字查询sign表的信息
     */
    public String getAllSignByName() {
        try {
            querySignService = CtxUtil.getBean(QuerySignService.class);
            signs = querySignService.getAllSignByName(input);
            return "querySignSuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "querySignFail";
        }
    }

    /*
     * 根据打卡创建时间查询sign表信息
     */
    public String getAllSignByCreateTime() {
        try {
            //  SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd ");
            //String date=sDateFormat.format(input);
            querySignService = CtxUtil.getBean(QuerySignService.class);
            signs = querySignService.getAllSignByCreatetime(input);
            return "querySignByDateSuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "querySignByDateFail";
        }
    }

    /*
     * 根据教师id查询sign表信息
     */
    public String getAllSignByTeaID() {
        try {

            querySignService = CtxUtil.getBean(QuerySignService.class);
            signs = querySignService.getAllSignByTeaid(Integer.parseInt(input));
            return "querySignSuccess";

        } catch (Exception e) {
            e.printStackTrace();
            return "querySignFail";
        }
    }

    /*
     * 查询某日期后还有效的打卡项
     */
    public String getAllSignValid() {
        try {

            querySignService = CtxUtil.getBean(QuerySignService.class);
            signs = querySignService.getAllSignValid(input);
            return "querySignByDateSuccess";

        } catch (Exception e) {
            e.printStackTrace();
            return "querySignByDateFail";
        }
    }

    /*
     * 根据打卡名模糊查询打卡信息
     */
    public String getAllSignFuzzilyByName() {
        try {

            querySignService = CtxUtil.getBean(QuerySignService.class);
            signs = querySignService.getAllSignfuzzilybyName(input);
            return "querySignFuzzilySuccess";

        } catch (Exception e) {
            e.printStackTrace();
            return "querySignFuzzilyFail";
        }
    }

    /*
     * 根据部分日期信息来模糊查询
     */
    public String getAllSignFuzzilyByCal() {
        try {

            querySignService = CtxUtil.getBean(QuerySignService.class);
            signs = querySignService.getAllSignfuzzilybyCal(input);
            return "querySignFuzzilySuccess";

        } catch (Exception e) {
            e.printStackTrace();
            return "querySignFuzzilyFail";
        }
    }

    /*
     * 用于基础查询打卡页面的action响应
     */
    public String querySign() {
        try {
            if (query.equals("0")) {
                return getAllSignByName();
            } else if (query.equals("1")) {

                return getAllSignByID();
            } else if (query.equals("2")) {
                return getAllSignByTeaID();
            }
            return "querySignFail";
        } catch (Exception e) {
            return "querySignFail";

        }
    }

    /*
     * 用于根据日期查询打卡页面的action响应
     */
    public String querySignByDate() {
        try {
            if (query.equals("0")) {
                return getAllSignByCreateTime();
            } else if (query.equals("1")) {

                return getAllSignValid();
            }
            return "querySignByDateFail";
        } catch (Exception e) {
            return "querySignByDateFail";
        }
    }

    /*
    用于模糊查询打卡页面的action响应
     */
    public String querySignFuzzily() {
        try {
            if (query.equals("0")) {
                return getAllSignFuzzilyByName();
            } else if (query.equals("1")) {

                return getAllSignFuzzilyByCal();
            }
            return "querySignFuzzilyFail";
        } catch (Exception e) {
            return "querySignFuzzilyFail";

        }

    }
}
