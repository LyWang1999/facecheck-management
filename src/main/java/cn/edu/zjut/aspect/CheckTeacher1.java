package cn.edu.zjut.aspect;

import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

/*lym：请修改命名*/
public class CheckTeacher1 {
    private Map<String, Object> request, session;

    public void checkTeacher() throws Exception {
        ActionContext ctx = com.opensymphony.xwork2.ActionContext.getContext();
        request = (Map) ctx.get("request");
        session = (Map) ctx.get("session");
        if (session.get("teacher") == null) {
            System.out.println("111111111111");
            String tip = "请先登录";
            request.put("tip", tip);
            /*   throw new Exception();*/
        }
    }
}
