/**
 * JWW
 */
package cn.edu.zjut.service;


import cn.edu.zjut.po.Admin;

public interface IAdminService {
    /**
     * 管理员登录
     */
    public boolean login(Admin admin);

    public boolean register(Admin admin);
}
