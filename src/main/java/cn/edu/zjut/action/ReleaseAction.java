package cn.edu.zjut.action;

import cn.edu.zjut.service.SendCodeService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope("prototype")
public class ReleaseAction {

    @Autowired
    private SendCodeService sendcode;

    /**
     * @Describe 接受ajax异步请求 调用接口发送语音短信
     * @throws Exception
     */
    public void sendmsg() throws Exception {

        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String phone = request.getParameter("phone");//得到手机号码
        System.out.println(phone);
        String msg = sendcode.sendmsg(phone);//发送手机号码相应信息
        System.out.println(msg);//显示打印回调信息


        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(msg);


    }


}
