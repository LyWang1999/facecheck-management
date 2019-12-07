package cn.edu.zjut.service;

import cn.edu.zjut.dao.AdminMapper;
import cn.edu.zjut.po.Admin;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class AdminService implements IAdminService {
    private Map<String, Object> session;

    @Autowired
    private AdminMapper adminMapper = null;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    @Override
    @Transactional
    public boolean login(Admin admin) {
        System.out.println("正在执行AdminService的login方法...");

        ActionContext ctx = ActionContext.getContext();
        session = ctx.getSession();
        Admin instance = new Admin();

        try {
            instance = adminMapper.findById(admin.getAdminID());

            if (instance == null) {
                System.out.println("未找到用户");
                return false;
            }
            if (admin.getPassword().equals(instance.getPassword())) {
                System.out.println("登录成功");
                admin = instance;
                session.put("admin", admin);
                return true;
            } else {
                System.out.println("密码错误");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean register(Admin admin) {
        try {
            adminMapper.saveAdmin(admin);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
