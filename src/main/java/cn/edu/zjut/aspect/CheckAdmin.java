package cn.edu.zjut.aspect;

import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

/*lym：请修改命名*/

/**
 * 检查点
 */
public class CheckAdmin {
    private Map<String, Object> request, session;

    public void checkAdmin() throws Exception {
        ActionContext ctx = com.opensymphony.xwork2.ActionContext.getContext();
        request = (Map) ctx.get("request");
        session = (Map) ctx.get("session");
        if (session.get("admin") == null) {
            System.out.println("11111");
            String tip = "请先登录";
            request.put("tip", tip);
            throw new Exception();
        }
    }
}
