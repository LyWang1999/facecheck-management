package cn.edu.zjut.po;

public class Admin {
    private int adminID;
    private String name;
    private String password;
    private Integer sex;
    private Integer phone;

    public Admin() {
    }

    public Admin(int adminId, String name, String password, Integer sex, Integer phone) {
        this.adminID = adminId;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
