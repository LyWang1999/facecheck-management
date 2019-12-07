package cn.edu.zjut.action;

import cn.edu.zjut.po.Admin;
import cn.edu.zjut.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("prototype")
@Controller
public class AdminAction {
    private Admin admin;

    @Autowired
    private IAdminService adminService = null;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    /**
     * 管理员登录
     */
    public String login() {
        System.out.println("正在执行AdminAction的login方法...");
        if (adminService.login(admin)) {
            return "success";
        } else
            return "fail";
    }

    /**
     * 管理员注册
     */
    public String register() {
        if (adminService.register(admin)) {
            return "success";
        }
        return "fail";
    }
}
